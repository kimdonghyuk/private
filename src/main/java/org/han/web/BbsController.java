package org.han.web;

import javax.inject.Inject;

import org.han.service.BbsService;
import org.han.service.Paging;
import org.han.vo.BbsVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bbs/*")
public class BbsController {

	@Inject
	BbsService service;

	@Inject
	Paging paging;
	
	@Inject
	BbsVO vo;
	
	
	@RequestMapping("/cboard")
	public String cboard(){
		return "bbs/cboard";
	}

	@RequestMapping("/create")
	public String create(@ModelAttribute BbsVO vo) {
		
		service.create(vo);
		return "redirect:list";
	}
	
	

	@RequestMapping("/list")
	public void list(@RequestParam(value="types", defaultValue="") String[] types, 
			@ModelAttribute Paging pm, Model model) {
		
		pm.setTypeArr(types);
		model.addAttribute("cnt", service.allCount());
		model.addAttribute("list", service.list(pm));
		model.addAttribute("paging", pm);

	}

}
