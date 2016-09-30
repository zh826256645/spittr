package test;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spittle;
import spittr.data.SpittleRepository;
import spittr.web.SpittleController;

public class SpittleControllerTest {

	// http://localhost:8888/Spittr/spittles
	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		// Mock Repository
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
			.thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRepository);
		// Mock Spring MVC
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
				.build();
		
		// 对 “/spittles” 发起 GET 请求
		mockMvc.perform(get("/spittles"))
			.andExpect(view().name("spittles"))
			.andExpect(model().attributeExists("spittleList"))
			.andExpect(model().attribute("spittleList", 
					hasItems(expectedSpittles.toArray())));
	}
	
	// http://localhost:8888/Spittr/spittles/1
	@Test
	public void testSpittle() throws Exception {
		Spittle expectedSpittle = new Spittle("Hello", new Date());
		// Mock Repository
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		// 当执行方法时，返回自己的值
		when(mockRepository.findOne(1)).thenReturn(expectedSpittle);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = standaloneSetup(controller).build();
	
		mockMvc.perform(get("/spittles/1"))
			.andExpect(view().name("spittle"))
			.andExpect(model().attributeExists("spittle"))
			.andExpect(model().attribute("spittle", expectedSpittle));
		
	}
	
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}
}
