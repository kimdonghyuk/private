package org.han.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Paging {
	
	private int page;		// 보여주려고 하는 page의 숫자
	private int cnt;		// 현재 페이지 구성하는데 필요한 데이터 수
	private int lineCount;	// 화면 당 페이지 개수?
	private int perPage;	// 페이지당 글 갯수
	private int startPage;  // 화면 페이지 첫번째
	private int endPage;    // 화면 페이지 마지막
	private int first;		// page에 첫번째 게시글 
	private int last;		// page에 마지막 게시글
	private List<Integer> lineList;
	private Map<String, String> crimap;
	private Map<String, String> colMap;
	private List<String> values;
	
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

	
	
	public int getStartPage() {
		int result = (int)((Math.floor((page-1)/(double)lineCount)) * lineCount) + 1;
		return result;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return (int)((Math.floor((page-1)/(double)lineCount) * lineCount) + 10);	
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getFirst() {
		return first = (int)((Math.floor(page/(double)lineCount) * lineCount))-10;

	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return (int)((Math.floor(page/(double)lineCount) * lineCount) + 10);
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPage() {
		return page;
	}

	public List<Integer> getLineList() {
		return lineList;
	}

	public Map<String, String> getCrimap() {
		return crimap;
	}

	public void setCrimap(Map<String, String> crimap) {
		this.crimap = crimap;
	}

	public Map<String, String> getColMap() {
		return colMap;
	}

	public void setColMap(Map<String, String> colMap) {
		this.colMap = colMap;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public int getPage(String str) {
		return page = Integer.parseInt(str);
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
	
//	public List<Integer> getlineList(){		
//		List<Integer> lineList = new ArrayList<Integer>();
//		
//		for (int i = 1; i < 11 ; i++) {
//			lineList.add((int)((Math.floor((page-1)/(double)lineCount)) * lineCount) + i);
//		}
//		return lineList;		
//	}
	
	public String getSql(){
		
		
		
		
		return "";
	}
	
//	public void calPage(){
//		first = (int)((Math.floor(page/(double)lineCount) * lineCount))-9;
//		last = (int)((Math.floor(page/(double)lineCount) * lineCount) + 10);
//		lineList = new ArrayList<Integer>();
//		
//		for (int i = 1; i < 11 ; i++) {
//			lineList.add((int)((Math.floor((page-1)/(double)lineCount)) * lineCount) + i);
//		}
//	}


	@Override
	public String toString() {
		return "Paging [page=" + page + ", cnt=" + cnt + ", lineCount="
				+ lineCount + ", perPage=" + perPage + ", first=" + first
				+ ", last=" + last + ", crimap=" + crimap + ", colMap="
				+ colMap + ", values=" + values + "]";
	}

	
	public static void main(String[] args) {
		Paging pm = new Paging();
		pm.setPage(10);
		int a = pm.getFirst();
		int b = pm.getStartPage();
		System.out.println( "끝값 :" + a + "첫값 :" + b);
	}
	
}
