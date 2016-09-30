package test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import spittr.web.HomeController;

/**
 * 测试控制器
 * 
 * @author 钟浩
 *
 */
public class HomeControllerTest {
	
	// 简单的 POJO 测试
	@Test
	public void testHomePage() {
		HomeController controller = new HomeController();
		Assert.assertEquals("home", controller.home());
	}
	
	// 使用 mock Spring MVC 并针对控制器执行 HTTP 请求的机制
	@Test
	public void testHomePage2() throws Exception {
		HomeController controller = new HomeController();
		// 搭建 MockMvc
		MockMvc mockMvc = standaloneSetup(controller).build();
		// 对 “/” 执行 GET 请求
		mockMvc.perform(get("/"))
			// 预期得到 home 视图
			.andExpect(view().name("home"));
	}
	
}
