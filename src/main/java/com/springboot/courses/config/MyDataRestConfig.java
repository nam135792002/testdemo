package com.springboot.courses.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.awt.print.Book;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private  String theAllowedOrigins = "http://localhost:5173";

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
                                                     CorsRegistry corsRegistry){
        HttpMethod[] theunsupportedActions = {HttpMethod.POST, HttpMethod.PATCH,
                HttpMethod.DELETE, HttpMethod.PUT};
        config.exposeIdsFor(Book.class);

        disableHttpMethods(Book.class, config, theunsupportedActions);

        corsRegistry.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration configuration,
                                    HttpMethod[] theUnsupportedActions){
        configuration.getExposureConfiguration()
                .forDomainType(theClass)
                .withAssociationExposure((metadata, httpMethods) ->
                        httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) ->
                        httpMethods.disable(theUnsupportedActions));
    }
}
