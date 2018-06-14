package com.goodelian.web;

import com.goodelian.model.Concat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

	private static final String ERROR_PATH = "/index";

	@GetMapping("/")
	public String index(ModelMap map) {
		// return模板文件的名称，对应src/main/resources/templates/index.html
		map.addAttribute("concat", new Concat());
		return "index";
	}

	@PostMapping("/concat")
	@ResponseBody
	public String concat(@ModelAttribute Concat concat) {
		return null;
	}

	@GetMapping("/test")
	public String test(ModelMap map) {
		// return模板文件的名称，对应src/main/resources/templates/index.html
		map.addAttribute("concat", new Concat());
		int a = 1/0;
		return "index";
	}
}