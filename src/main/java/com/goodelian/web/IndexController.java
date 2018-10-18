package com.goodelian.web;

import com.goodelian.model.Concat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

	private static final String ERROR_PATH = "/index";

	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/")
	public String index(ModelMap map) {
		// return模板文件的名称，对应src/main/resources/templates/index.html
		map.addAttribute("concat", new Concat());
		return "index";
	}

	protected static final String MY_MAIL = "15112222289@163.com";

	@PostMapping("/concat")
	@ResponseBody
	public void concat(@ModelAttribute Concat concat) {
		if (concat == null || concat.getMessage().trim().length() == 0
				|| concat.getMessage().trim().length() > 102400) {
			return;
		}
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(MY_MAIL);
		message.setTo(MY_MAIL);
		message.setSubject(concat.getSubject());
		message.setText(concat.getMessage());
		javaMailSender.send(message);
		// TODO save from who
	}

	@GetMapping("/test")
	public String test(ModelMap map) {
		// return模板文件的名称，对应src/main/resources/templates/index.html
		map.addAttribute("concat", new Concat());
		int a = 1 / 0;
		return "index";
	}
}