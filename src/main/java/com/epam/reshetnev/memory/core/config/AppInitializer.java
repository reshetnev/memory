package com.epam.reshetnev.memory.core.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.epam.reshetnev.memory.core.repository.config.DataConfig;

/**
 * Replacement for most of the content of web.xml, sets up the root and the servlet context config.
 */

public class AppInitializer implements WebApplicationInitializer  {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // root context
//        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(RootConfig.class); // configuration class for root context
//        rootContext.setConfigLocation("classpath:applicationContext.xml");
//        rootContext.scan("...service", "...dao"); // scan only some packages
//        servletContext.addListener(new ContextLoaderListener(rootContext));

        // dispatcher servlet 1
        AnnotationConfigWebApplicationContext webContext1 = new AnnotationConfigWebApplicationContext();
//        webContext1.setParent(rootContext);
        webContext1.register(MvcConfig.class); // configuration class for servlet 1
//        webContext1.scan("...web1");            // scan some other packages
        ServletRegistration.Dynamic dispatcher1 =
        servletContext.addServlet("dispatcher1", new DispatcherServlet(webContext1));
        dispatcher1.setLoadOnStartup(1);
        dispatcher1.addMapping("/");

        // dispatcher servlet 2
        // ...
    }

}
