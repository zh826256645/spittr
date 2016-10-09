package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Spring-Security 第二步
 * 1.@EnableWebMvcSecurity 注解将会启动 Web 安全功能，
 * 	此时会自动创建 springSecurityFilterChain 以及它链接一起的其他 Filter
 * 2.Spring Security 必须配置在一个实现了 WebSecurityConfigurer 的 bean 中
 * 3.通过重载 3 个方法来指定 Web 安全的细节
 * 	>> configure(WebSecurity):通过重载,配置 Spring Security 的 Filter 链
 * 	>> Configure(HttpSecurity):通过重载，配置如何通过拦截器保护请求
 * 	>> Configure(AuthenticationManagerBuilder):通过重载，配置 user-detail 服务
 * 
 * @author 钟浩
 *
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// 配置 user-detial
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		// 将用户放在内存中，用于测试
		.inMemoryAuthentication()
		// 两个用户，对应不同的权限
		.withUser("zhonghao").password("123456").roles("SPITTER").and()
		.withUser("admin").password("123456").roles("SPITTER", "ADMIN");
	}
	
	// 配置 URL 的安全策略
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			// 启动 登录页面
			.formLogin()
				// 设置登录页面
				.loginPage("/login")
			.and()
				// 设置登出
				// 开启了 CSRF 防护功能必须使用 POST 进行提交
				.logout()
					// 重写默认的 LogoutFilter 拦截路径
					.logoutUrl("/logout")
					// 设置登出页面
					.logoutSuccessUrl("/")
			// 设置用户认证，以及 URI 的访问权限
			.and()
			.authorizeRequests()
				// 设置 URI "/spitter.me" 需要认证，还需要 ROLE_SPITTER 权限
				.antMatchers("/spitter/me").hasRole("SPITTER")
				// 设置 URI "/spittles" POST 需要认证，还需要 ROLE_SPITTER 权限
				.antMatchers(HttpMethod.POST, "/spittles").hasRole("SPITTER")
				// 设置其他 URI 不要认证，放在最后
				.anyRequest().permitAll();
			//.and()
			// 设置 URI 的访问协议 HTTP 或 HTTPS
			// 要使用 HTTPS 必须开启服务器的 HTTPS 服务
			// .requiresChannel()
				// 访问 URI "/spitter/form" 强制使用 HTTPS
				//.antMatchers("/spitter/register").requiresSecure()
				//.antMatchers("/login").requiresSecure()
				// 访问 URI "/" 强制使用 HTTP
				// .antMatchers("/").requiresInsecure();
	}
}

