package com.epam.reshetnev.memory.core.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.epam.reshetnev.memory.core.repository.config.DataConfig;

/**
 * Replacement for most of the content of web.xml, sets up the root and the servlet context config.
 */

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{ RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

//	@Override
//	protected Filter[] getServletFilters() {
//		final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//		encodingFilter.setEncoding("UTF-8");
//		encodingFilter.setForceEncoding(true);
//		final DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("springSecurityFilterChain");
//		return new Filter[]{encodingFilter, delegatingFilterProxy};
//	}
}
