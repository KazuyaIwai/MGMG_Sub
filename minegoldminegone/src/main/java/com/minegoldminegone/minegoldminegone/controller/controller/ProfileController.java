package com.minegoldminegone.minegoldminegone.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class ProfileController {


	@RequestMapping(value = "", method = RequestMethod.GET)
	public String profileHome() {
		return "profile";
	}
}