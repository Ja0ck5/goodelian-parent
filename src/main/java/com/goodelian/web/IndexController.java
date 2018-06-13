package com.goodelian.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static final String ERROR_PATH = "/index";

	@RequestMapping("/")
	public String index(ModelMap map) {
		// return模板文件的名称，对应src/main/resources/templates/index.html
		return "index";
	}

}