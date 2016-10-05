package spittr.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			Errors errors, 
			RedirectAttributes model) {
		// 校验出错，跳转到登录页面
		if (errors.hasErrors()) {
			return "registerForm";
		}
		// 保存用户
		Spitter spitter_this = spittlerRepository.save(spitter);
		// 将 Spitter 数据保存到 flash 属性中，重定向后取出
		model.addFlashAttribute("spitter", spitter_this);
		model.addAttribute("username", spitter_this.getUsername());
		// username 以模板的形式填充到 URL 中，这样更安全
		return "redirect:/spitter/{username}";
	}

	// 用户页面
	// URI：/spitter/{username} GET
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(
			@PathVariable("username") final String username,
			Model model
			) {
		// 如果模型中不存在 spitter 属性，去数据库中查询，存在直接转发到 view
		if(!model.containsAttribute("spitter")) {
			model.addAttribute(spittlerRepository.
					findByUsername(username));
		}
		return "profile";
	}
}
