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
		
		model.addAttribute("read",service.read(bno));	// bno�� ��Ƽ� �ش� page�� hidden���� ��Ƽ� �̵���.
		
	}
	
	@RequestMapping("/delete")
	public String update(@RequestParam(value="bno", defaultValue="") int bno, Model model){
		service.delete(bno);		// delete �ϴ� query��
		return "redirect:list";		// delete�� �Ϸ��� �� list page�� redirect�Ѵ�.
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
		model.addAttribute("up", service.read(vo.getBno()));	// �����Ϸ��� ������ �������� �о�鿩 ���� �� ������ ������.
	}	
	
	@RequestMapping("/update")
	public String update(@ModelAttribute BbsVO bno ){
		service.update(bno);									// update ������ �ʿ��� bno, title, cont �� ���� vo�� ������.
		return "redirect:read?bno=" + bno.getBno();		// ������ �Ŀ� �ش� page�� �̵��Ͽ� ������ ����� �������� redirect ����.
	}

}
