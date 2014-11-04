package org.han.web;

import javax.inject.Inject;

import org.han.service.BbsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/bbs/*")
public class BbsController {
	
	@Inject
	BbsService service;
	
	 @RequestMapping("/list")
	 public String list(@RequestParam(value="page", defaultValue="2") String
	 page, Model model){
	
	 model.addAttribute("list" , service.list(page));
	
	 return "bbs/list";
	
	 }
	

}
