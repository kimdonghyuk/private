package org.han.web;

import javax.inject.Inject;

import org.han.service.BbsService;
import org.han.service.Paging;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/bbs/*")
public class BbsController {
	
	@Inject
	BbsService service;
	
	@Inject
	Paging paging;
	
	 @RequestMapping("/list")
	 public String list(@RequestParam(value="page", defaultValue="1") String
	 page, Model model){
	
		 
	 model.addAttribute("list" , service.list(page));
	 model.addAttribute("paging", paging);
	
	 return "bbs/list";
	
	 }
	

}
