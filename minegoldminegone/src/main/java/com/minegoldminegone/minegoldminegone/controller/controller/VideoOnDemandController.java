package com.minegoldminegone.minegoldminegone.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minegoldminegone.minegoldminegone.model.VideoSummary;
import com.minegoldminegone.minegoldminegone.repository.VideoSummaryRepository;

@Controller
@RequestMapping("/stream")
public class VideoOnDemandController {

	@Autowired
	private VideoSummaryRepository videoSummaryRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String profileHome(@PageableDefault(size = 20) Pageable pageable, Model model) {

		Page<VideoSummary> page = videoSummaryRepository.findAllByOrderById(pageable);

		model.addAttribute("page", page);
		model.addAttribute("path", "/stream");
		model.addAttribute("list", page.getContent());

		return "vod/main";
	}
}