package com.kknyrik.euro2016.config;

import com.kknyrik.euro2016.exceptions.ExceptionService;
import cz.jirutka.spring.exhandler.RestHandlerExceptionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Configuration
public class ErrorsConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ContentNegotiationManager contentNegotiationManager;

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;


    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add( exceptionHandlerExceptionResolver() );
        resolvers.add( restExceptionResolver() );
    }

    @Bean
    public RestHandlerExceptionResolver restExceptionResolver() {
        contentNegotiationManager.resolveFileExtensions(MediaType.APPLICATION_JSON);
        return RestHandlerExceptionResolver.builder().messageSource(httpErrorMessageSource())
                .defaultContentType(MediaType.APPLICATION_JSON)
                .contentNegotiationManager(contentNegotiationManager)
                .httpMessageConverters(requestMappingHandlerAdapter.getMessageConverters())

                .addErrorMessageHandler(ExceptionService.TeamNotFoundException.class, HttpStatus.NOT_FOUND)
                .addErrorMessageHandler(ExceptionService.PlayerNotFoundException.class, HttpStatus.NOT_FOUND)
                .addErrorMessageHandler(ExceptionService.GameNotFoundException.class, HttpStatus.NOT_FOUND)
                .addErrorMessageHandler(ExceptionService.GroupNotFoundException.class, HttpStatus.NOT_FOUND)
                .addErrorMessageHandler(AccessDeniedException.class, HttpStatus.FORBIDDEN)
                .addErrorMessageHandler(Exception.class, HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @Bean
    public MessageSource httpErrorMessageSource() {
        ReloadableResourceBundleMessageSource m = new ReloadableResourceBundleMessageSource();
        m.setBasename("classpath:/com/kknyrik/euro2016/exceptions/message");
        m.setDefaultEncoding("UTF-8");
        return m;
    }

    @Bean
    public ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver() {
        ExceptionHandlerExceptionResolver resolver = new ExceptionHandlerExceptionResolver();
        resolver.setContentNegotiationManager(contentNegotiationManager);
        resolver.setMessageConverters(requestMappingHandlerAdapter.getMessageConverters());
        return resolver;
    }

}
