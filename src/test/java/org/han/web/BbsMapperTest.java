package org.han.web;

import javax.inject.Inject;

import org.han.service.BbsService;
import org.han.service.Paging;
import org.han.vo.BbsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/**/*-context.xml" })
public class BbsMapperTest {

	@Inject
	BbsService service;
	
	@Inject
	BbsVO vo;


	@Test
	public void createTest() {
		vo.setTitle("title");
		vo.setUserid("han07");
		vo.setCont("�ٵ� ���� �����Ͻð� ���� �ϵ鸸 �����Ͻñ⸦");
		service.create(vo);
	}
	
	@Test
	public void readTest(){
		System.out.println(service.read(452));
	}
	
	@Test
	public void listTest(){
		Paging pm = new Paging();
		System.out.println(service.list(pm));
	}
	
	@Test
	public void updateTest(){
		vo.setTitle("������������ ������ �޾��ּ���");
		vo.setCont("�츮 ������ ������ ������ ���� ���� �޾��ּ���~");
		vo.setBno(522);
		service.update(vo);
		System.out.println(service.read(522));
	}
	
	
//	@Test
//	public void pagingTest(){
//		List<BbsVO> list = service.list("2");
//		System.out.println(list);
//	}

}
