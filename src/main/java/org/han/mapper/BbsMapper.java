package org.han.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.han.vo.BbsVO;

public interface BbsMapper {

	@Insert("insert into tbl_bbs (bno, title, userid, cont)"+
			" values(seq_bbs.nextval, #{title}, #{userid}, #{cont})")
	public void create(BbsVO vo);
	// create : 글을 등록하는 기능으로 게시판의 메인 화면 요소들이 필요하며 그것을 담고 있는 vo의 객체가 input paramter임.

	@Select("select * from tbl_bbs where bno=#{bno}")
	public BbsVO read(String bno);
	
	@Update("update tbl_bbs set title=#{title} where bno=#{bno}")
	public void update(BbsVO vo);
	
	@Delete("delete from tbl_bbs where bno=#{bno}")
	public void delete(String bno);
	
	@Select("select bno,"
			+" (case when sysdate - regdate < 1 then '\"new\"' end)||title||(case when rcount = 0 then ' ' when rcount>0 then '['||rcount||']' end) title,"
			+"userid, regdate, vcount from"
			+" (select /*+index_desc(tbl_bbs pk_bbs)*/ rownum rn, bno, title, userid, regdate, vcount, rcount from tbl_bbs where bno>0 and rownum<=(ceil(#{page}/10)*100)+1)"
			+" where rn > (#{page}-1)*10 and rn<=(#{page}*10)")
	public List<BbsVO> list(String page);
	
	@Select("select count(bno) cnt from tbl_bbs")
	public String allCount();
	
	
}
