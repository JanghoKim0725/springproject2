package com.myhome.dto;

public class DefaultDto {

	// 검색 조건
	String searchField;
	
	// 검색 단어
	String  searchWord;
	
	// 현재페이지 번호
	int pageIndex = 1;
	
	// 한 화면에서의 출력 단위
	int pageUnit = 10;
	
	// 1 ~ 10 [next] // 11 ~ 20
	int pageSize = 10;
	
	// 시작 페이지 번호
	int firstPage = 1;
	
	// 종료 페이지 번호
	int lastPage  = 1;
	
	// SQL의 시작번호
	int firstIndex = 0;
	
	// SQL의 종료번호
	int lastIndex  = 0;
	
	// 총 데이터개수
	int total = 0;
		
	// 총 페이지개수
	int totalPage = 0;
	
	// 출력페이지의 시작번호
	int pageRownum = 0;
		
	public String getSearchField() {return searchField;}
	public void setSearchField(String searchField) {this.searchField = searchField;}

	public String getSearchWord() {return searchWord;}
	public void setSearchWord(String searchWord) {this.searchWord = searchWord;}
	
	public int getPageIndex() {return pageIndex;}
	public void setPageIndex(int pageIndex) {this.pageIndex = pageIndex;}

	public int getPageUnit() {return pageUnit;}
	public void setPageUnit(int pageUnit) {this.pageUnit = pageUnit;}

	public int getPageSize() {return pageSize;}
	public void setPageSize(int pageSize) {this.pageSize = pageSize;}

	public int getFirstPage() {return firstPage;}
	public void setFirstPage(int firstPage) {this.firstPage = firstPage;}

	public int getLastPage() {return lastPage;}
	public void setLastPage(int lastPage) {this.lastPage = lastPage;}
	
	public int getFirstIndex() {return firstIndex;}
	public void setFirstIndex() {this.firstIndex = (pageIndex - 1) * pageUnit + 1;}
	
	public int getLastIndex() {return lastIndex;}
	public void setLastIndex() {this.lastIndex = firstIndex + (pageUnit - 1);}
	
	public int getTotal() {return total;}
	public void setTotal(int total) {this.total = total;}
	
	public int getTotalpage() {return totalPage;}
	public void setTotalpage() {this.totalPage = (int)Math.ceil((double)total/pageUnit);}
	
	public int getPageRownum() {return pageRownum;}
	public void setPageRownum() {this.pageRownum = total - (pageIndex - 1) * pageUnit;}	
}