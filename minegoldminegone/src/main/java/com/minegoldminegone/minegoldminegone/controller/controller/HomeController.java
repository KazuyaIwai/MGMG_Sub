package com.minegoldminegone.minegoldminegone.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {


	@RequestMapping("/")
	public String index() {
		return "spa/home";
	}

	@RequestMapping("/home")
	public String home() {
		return "spa/home";
	}
}