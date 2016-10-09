package spittr.config;


import java.util.regex.Pattern;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.test.context.ActiveProfiles;

import spittr.data.SpitterData;
import spittr.data.SpittleData;
import spittr.data.SpittleRepository;
import spittr.data.SpittlerRepository;

import spittr.config.RootConfig.WebPackage;
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
    @Filter(type=FilterType.CUSTOM, value=WebPackage.class)
})
@ActiveProfiles("noData")
public class RootConfig {
	
	  public static class WebPackage extends RegexPatternTypeFilter {
		    public WebPackage() {
		      super(Pattern.compile("spittr\\.web"));
		    }    
		  }
	
	@Bean
	public SpittleRepository spittleRepository() {
		return new SpittleData();
	}
	
	@Bean
	public SpittlerRepository spittlerRepository() {
		return new SpitterData();
	}
	
	
}
