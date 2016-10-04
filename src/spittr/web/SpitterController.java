package spittr.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpittlerRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {


	private SpittlerRepository spittlerRepository;
	
	@Autowired
	public SpitterController(SpittlerRepository spittlerRepository) {
		this.spittlerRepository = spittlerRepository;
	}

	public SpitterController() {
		super();
	}
	
	// 访问注册页面
	// URI:/spitter/register GET
	// return:registerForm.jsp
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		// 添加 Spitter 实例模型
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	
	// 用户注册
	// URI:/spitter/register POST
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(
			// 启动校验
			@Valid Spitter spitter,
			// 保存校验出现的错误
			Errors errors) {
		// 校验出错，跳转到登录页面
		if (errors.hasErrors()) {
			return "registerForm";
		}
		// 保存用户
		spittlerRepository.save(spitter);
		// 重定向到用户页面
		return "redirect:/spitter/" + spitter.getUsername();
	}
	
	// 用户页面
	// URI：/spitter/{username} GET
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(
			@PathVariable("username") final String username,
			Model model
			) {
		model.addAttribute(spittlerRepository.
				findByUsername(username));
		return "profile";
	}
}
