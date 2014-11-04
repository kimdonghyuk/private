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
	
	public void delete(String bno){
		mapper.delete(bno);
	}
	
	public BbsVO read(String bno) {
		return mapper.read(bno);
	}

	public List<BbsVO> list(String page) {
		return mapper.list(page);
	}

}
