package spittr.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * 第二步：Spring MVC 配置类
 * 
 * @author 钟浩
 *
 */
@Configuration
// Spring MVC 配置
@EnableWebMvc
// 启动自动扫描
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	// 配置 JSP 视图解析器
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// 加前缀
		resolver.setPrefix("/WEB-INF/views/");
		// 加后缀
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	// 配置静态资源的处理
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// 不使用 DispatcherServlet 处理
		// 交给 Servlet 容器中默认的 Servlet 处理
		configurer.enable();
	}
}
