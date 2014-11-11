package org.han.service;

import java.util.List;

import javax.inject.Inject;

import org.han.mapper.BbsMapper;
import org.han.vo.BbsVO;
import org.springframework.stereotype.Service;

@Service
public class BbsService {

	@Inject
	BbsMapper mapper;

	public void create(BbsVO vo) {
		mapper.create(vo);
	}

	
	public void update(BbsVO vo){
		mapper.update(vo);
	}
	
	
	public void delete(int bno){
		mapper.delete(bno);
	}
	
	
	public BbsVO read(int bno) {
		return mapper.read(bno);
	}

	
	public List<BbsVO> list(Paging pm) {
		return mapper.list(pm);
	}
	
	
	public int allCount(){
		int cnt = Integer.parseInt(mapper.allCount());
		Paging page = new Paging();
		
		int perpage = page.getPerPage();
		int result = (int)(Math.ceil(cnt/(double)perpage) + 1);
		return result;
	}

}
