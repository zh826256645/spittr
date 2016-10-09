package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 第四步：编写控制器
 * 
 * @author 钟浩
 *
 */

// 声明控制器
// 自带 @Component 注解
@Controller
// 将控制器映射到 “/”
@RequestMapping(value="/")
public class HomeController {
	
	// 处理 GET 请求
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		// 返回逻辑视图
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
}
