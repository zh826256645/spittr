package test;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.test.web.servlet.MockMvc;

import org.junit.Test;

import spittr.Spitter;
import spittr.data.SpittlerRepository;
import spittr.web.SpitterController;
import spittr.web.SpittleController;

public class SpitterControllerTest {

	
	@Test
	public void shouldShowRegistration() throws Exception {
		SpitterController controller = new SpitterController();
		// 构建 MockMvc
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		// 断言 registerForm 视图
		mockMvc.perform(get("/spitter/register"))
			.andExpect(view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		// 构建 Repository
		SpittlerRepository mockRepository = mock(SpittlerRepository.class);
		Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer", "123456@gmail.com");
		Spitter saved = new Spitter(2L,"jbauer", "24hours", "Jack", "Bauer", "123456@gmail.com" );
		when(mockRepository.save(unsaved)).thenReturn(saved);
		
		SpitterController controller = new SpitterController(mockRepository);
		// 构建 MockMvc
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/spitter/register")
				// 设置传入参数
				.param("firstName", "Jack")
				.param("lastName", "Bauer")
				.param("username", "jbauer")
				.param("password", "24hours")
				.param("email", "123456@gmail.com"))
			// 比较是不是返回预期的 RUI
			.andExpect(redirectedUrl("/spitter/jbauer"));
		
		// 校验保存请求
		verify(mockRepository, atLeastOnce()).save(unsaved);
	}
	
	@Test
	public void shouldShowSpitter() throws Exception {
		// 构建 Repository
		SpittlerRepository mockRepository = mock(SpittlerRepository.class);
		Spitter expectedSpitter = new Spitter(1L, "zh826256645", "123", "Zhong", "Hao", "826256645@qq.com");
		// 当执行方法时，设置返回值
		when(mockRepository.findByUsername("zh826256645")).thenReturn(expectedSpitter);
		
		SpitterController controller = new SpitterController(mockRepository);
		// 构建 MockMvc
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		// 发送请求
		mockMvc.perform(get("/spitter/zh826256645"))
			// 断言：返回视图是否符合预期
			.andExpect(view().name("profile"))
			// 断言：返回模型名是否符合预期
			.andExpect(model().attributeExists("spitter"))
			// 断言：返回模型内容是否符合预期
			.andExpect(model().attribute("spitter", expectedSpitter));
	}
}
