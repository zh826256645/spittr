package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	private SpittleRepository spittleRepository;
	
	// 注入 SpittleRepository
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(
			// 设置 url 参数，并设置默认值
			@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING)final long max, 
			@RequestParam(value="count", defaultValue="20") final int count, 
			Model model) {
		// 将 spittle 添加到模型中
		model.addAttribute("spittleList",
				spittleRepository.findSpittles(
						max, count));
		// 返回逻辑视图
		return "spittles";
	}
	
	// REST
	// 将路径作为参数
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String spittle(
			@PathVariable("spittleId") final long spittleId,
			Model model) {
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
}
