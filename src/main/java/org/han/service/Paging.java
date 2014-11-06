package org.han.service;

import org.springframework.stereotype.Service;

@Service
public class Paging {

	private int page;		// 보여주려고 하는 page의 숫자
	private int cnt;		// 현재 페이지 구성하는데 필요한 데이터 수
	private int lineCount;	// 화면 당 페이지 개수?
	private int perPage;	// 페이지당 글 갯수
	private int first;		// page에 첫번째 게시글 
	private int last;		// page에 마지막 게시글
	
	private int RnFirst;
	private int RnLast;
	
	private boolean hasNext = false;
	private boolean hasBefore = false;
	
	public static int getNumber(String str){
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			return 1;
		}
	}
	
	public Paging(){
		this(1);
	}
	
	public Paging(int page){
		this(page, 0);
	}
	
	public Paging(String pageStr){
		this(getNumber(pageStr),0);
	}
	
	public Paging(int page, int cnt) {
		this(page, cnt, 10,10);
	}
	
	public Paging(int page, int cnt, int lineCount, int perPage) {
		super();
		this.page = page;
		this.cnt = cnt;
		this.lineCount = lineCount;
		this.perPage = perPage;
		this.first = 1;
		this.last = 10;
	}
	

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	
	public int getRowNum(){
		
		return (  ( (int)(Math.ceil(page/(double)perPage)) ) * (perPage * lineCount))  +1;
	 	
	}
	
	public int getRnFirst(){
		
		return getRnLast() - perPage ;
	}
	
	public int getRnLast(){
		
		return (page * perPage);
	}
	

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", cnt=" + cnt + ", lineCount="
				+ lineCount + ", perPage=" + perPage + "]";
	}
	
	public static void main(String[] args) {

		Paging maker = new Paging(12);
		System.out.println(maker.getRowNum());
	}
	
	
}
