package spittr.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;

/**
 * 第一步：配置 DispatcherServlet
 * 
 * @author 钟浩
 *
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// 设置 DispatcherServlet 映射
	// 将 DispatcherServlet 映射到 “/”
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	// 指定配置类:RootConfig
	// 配置 ContextLoaderListener 创建的应用上下文中的 bean
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	// 指定配置类:WebConfig
	// 定义 DispatcherServlet 应用上下文中 bean
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebConfig.class};
	}
	
}
