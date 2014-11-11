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
	
	@RequestMapping("/read")
	public void read(@RequestParam(value="bno", defaultValue="") int bno, Model model){
		
		model.addAttribute("read",service.read(bno));	// bno를 담아서 해당 page로 hidden값을 잡아서 이동함.
		
	}
	
	@RequestMapping("/delete")
	public String update(@RequestParam(value="bno", defaultValue="") int bno, Model model){
		service.delete(bno);		// delete 하는 query문
		return "redirect:list";		// delete를 완료한 후 list page로 redirect한다.
	}
	
	

	@RequestMapping("/list")
	public void list(@RequestParam(value="types", defaultValue="") String[] types, 
			@ModelAttribute Paging pm, Model model) {
		
		pm.setTypeArr(types);
		model.addAttribute("cnt", service.allCount());
		model.addAttribute("list", service.list(pm));
		model.addAttribute("paging", pm);

	}
	
	@RequestMapping("/upboard")
	public void upboard(@ModelAttribute BbsVO vo, Model model){
		model.addAttribute("up", service.read(vo.getBno()));	// 수정하려고 선택한 페이지를 읽어들여 수정 전 정보를 보여줌.
	}	
	
	@RequestMapping("/update")
	public String update(@ModelAttribute BbsVO bno ){
		service.update(bno);									// update 쿼리에 필요한 bno, title, cont 를 가진 vo를 던져줌.
		return "redirect:read?bno=" + bno.getBno();		// 수정한 후에 해당 page로 이동하여 수정한 모습을 보기위해 redirect 해줌.
	}

}
