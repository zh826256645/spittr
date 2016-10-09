package spittr.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Spring-Security 第一步
 * 
 * 1.配置 DelegatingFilterProxy
 * 2.一个特殊的 Servlet Filter
 * 3.用于将工作委托给一个 javax.servlet.Filter 实现类，Spring 中是 ID 为 springSecurityFilterChain bean
 * 4.AbstractSecurityWebApplicationInitializer 实现了 WebApplicationInitializer,Spring 会发现它
 * 5.不需要重载任何方法，会自动在 Web 容器中注册 DelegatingFilterProxy
 * 
 * @author 钟浩
 *
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer{

}
