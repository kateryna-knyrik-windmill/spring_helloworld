package com.kknyrik.euro2016.config;

import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * for business logic
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * for web context
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ErrorsConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {
        super.registerDispatcherServlet(servletContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("name", new WebServlet());
        dynamic.addMapping("/console/*");
        dynamic.setInitParameter("webAllowOthers", Boolean.toString(true));
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic reg) {
        reg.setInitParameter("throwExceptionIfNoHandlerFound", Boolean.toString(true));
    }

}
