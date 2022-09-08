package com.test.legacy.template;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//이게 DispatcherServlet임
//공식 문서의 자바 베이스 설정을 Class<?> 이거 3개로 알려줌
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		return super.createRootApplicationContext();
	}

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		return super.createServletApplicationContext();
	}
	
	@Override
	    protected Filter[] getServletFilters() {
	        return new Filter[] {
	            new HiddenHttpMethodFilter(), new CharacterEncodingFilter() };
	}

	// Root Context
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	// Servlet Context (EnableWebMvc, WebConfigurer)
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}

	@Override
	protected void registerDispatcherServlet(ServletContext servletContext) {
		super.registerDispatcherServlet(servletContext);
	}

	@Override
	protected String getServletName() {
		return super.getServletName();
	}

	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		return super.createDispatcherServlet(servletAppContext);
	}

	@Override
	protected ApplicationContextInitializer<?>[] getServletApplicationContextInitializers() {
		return super.getServletApplicationContextInitializers();
	}

	@Override
	protected String[] getServletMappings() {
		return null;
	}

	@Override
	protected Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
		return super.registerServletFilter(servletContext, filter);
	}

	@Override
	protected boolean isAsyncSupported() {
		return super.isAsyncSupported();
	}

	@Override
	protected void customizeRegistration(javax.servlet.ServletRegistration.Dynamic registration) {
		super.customizeRegistration(registration);
	}

	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {
		super.registerContextLoaderListener(servletContext);
	}

	@Override
	protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
		return super.getRootApplicationContextInitializers();
	}

	
	
}
