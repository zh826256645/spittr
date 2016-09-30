package spittr.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import spittr.data.SpitterData;
import spittr.data.SpittleData;
import spittr.data.SpittleRepository;
import spittr.data.SpittlerRepository;


/**
 * 第三步：配置 ContextLoaderListener 配置类
 * 
 * @author 钟浩
 *
 */
@Configuration
// 自动扫描
@ComponentScan(basePackages={"spittr"},
	excludeFilters={
		@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
	})
@ActiveProfiles("noData")
public class RootConfig {
	
	@Bean
	public SpittleRepository spittleRepository() {
		return new SpittleData();
	}
	
	@Bean
	public SpittlerRepository spittlerRepository() {
		return new SpitterData();
	}
}
