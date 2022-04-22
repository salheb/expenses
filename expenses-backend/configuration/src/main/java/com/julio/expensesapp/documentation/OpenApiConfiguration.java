package com.julio.expensesapp.documentation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import static java.util.function.Predicate.not;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpStatus.*;

import java.util.List;

@Profile("secure-api")
@Configuration
@EnableWebMvc
@EnableOpenApi
public class OpenApiConfiguration implements WebMvcConfigurer {

    @Value("${build.version:1.0-SNAPSHOT}")
    private String buildVersion;

    @Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.OAS_30)
                .ignoredParameterTypes(ServletWebRequest.class)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any().and(not(PathSelectors.ant("/error"))))
                .build()
                .globalResponses(GET, globalGetDeleteResponseMessages())
                .globalResponses(DELETE, globalGetDeleteResponseMessages())
                .globalResponses(POST, globalPostPutResponseMessages())
                .globalResponses(PUT, globalPostPutResponseMessages())
                .useDefaultResponseMessages(false)
                .apiInfo(buildApiInfo())
                .securitySchemes(List.of(apiKey()))
                .securityContexts(List.of(buildSecurityContext()));
        addTags(docket);
        return docket;
    }

    private void addTags(Docket docket){
        docket.tags(new Tag("Expenses", "Personal Expenses Administration"));
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Personal Expenses Administration API")
                .description("Control your incomes and expenses")
                .version(buildVersion)
                .contact(new Contact("Julio Nogueira",
                        "https://www.linkedin.com/in/juliocesarsn/", "julio.salheb@gmail.com"))
                .build();
    }

    private List<Response> globalPostPutResponseMessages() {
        return List.of(
                new ResponseBuilder()
                        .code(getHttpStatus(UNAUTHORIZED))
                        .description("Unauthorized")
                        .build(),
                new ResponseBuilder()
                        .code(getHttpStatus(NOT_ACCEPTABLE))
                        .description("Resource has no representation that could be accepted by the consumer")
                        .build(),
                new ResponseBuilder()
                        .code(getHttpStatus(UNSUPPORTED_MEDIA_TYPE))
                        .description("Request declined because the payload media type is not supported")
                        .build()
                ,new ResponseBuilder()
                        .code(getHttpStatus(INTERNAL_SERVER_ERROR))
                        .description("Internal server error")
                        .build());
    }

    private List<Response> globalGetDeleteResponseMessages() {
        return List.of(
                new ResponseBuilder()
                        .code(getHttpStatus(UNAUTHORIZED))
                        .description("Unauthorized")
                        .build(),
                new ResponseBuilder()
                        .code(getHttpStatus(INTERNAL_SERVER_ERROR))
                        .description("Internal server error")
                        .build());
    }

    private String getHttpStatus(HttpStatus status) {
        return Integer.toString(status.value());
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    private SecurityContext buildSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(buildSecurityReference())
                .operationSelector(operationContext -> true)
                .build();
    }

    private List<SecurityReference> buildSecurityReference() {
        AuthorizationScope authorizationScopeFull = new AuthorizationScope("*", "Full access");
        AuthorizationScope authorizationScopeUser = new AuthorizationScope("User", "Access to user own data");

        AuthorizationScope[] authorizationScopes = new AuthorizationScope[2];
        authorizationScopes[0] = authorizationScopeFull;
        authorizationScopes[1] = authorizationScopeUser;

        return List.of(new SecurityReference("Authorization", authorizationScopes));
    }


}
