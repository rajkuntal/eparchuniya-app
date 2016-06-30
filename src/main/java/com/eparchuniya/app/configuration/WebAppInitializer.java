package com.eparchuniya.app.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebAppRootConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebAppConfiguration.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }   
  
}
