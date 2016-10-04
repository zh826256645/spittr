package spittr.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


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
	
	// 配置 TilesConfigurer
	@Bean
	public TilesConfigurer TilesConfigurer() {
		// 定义 Tiles 位置
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[] {
				"/WEB-INF/layout/tiles.xml"
		});
		// 启用刷新
		tiles.setCheckRefresh(true);
		return tiles;
	}
	
	// 配置 Tiles3 视图解析器
	@Bean
	public ViewResolver viewResolver() {
		return new TilesViewResolver();
	}
	
	// 配置静态资源的处理
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// 不使用 DispatcherServlet 处理
		// 交给 Servlet 容器中默认的 Servlet 处理
		configurer.enable();
	}
}
