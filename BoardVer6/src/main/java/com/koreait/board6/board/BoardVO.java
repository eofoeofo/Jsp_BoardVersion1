package com.koreait.board6.board;

public class BoardVO {
	private int iboard;
	private int iuser;
	private String title;
	private String ctnt;
	private String regdt;
	private String unm;
	private int loginIuser;
	private int isFav;
	
	private int sIdx;
	private int page;
	private String search;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getsIdx() {
		return sIdx;
	}
	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getIsFav() {
		return isFav;
	}
	public void setIsFav(int isFav) {
		this.isFav = isFav;
	}
	public int getLoginIuser() {
		return loginIuser;
	}
	public void setLoginIuser(int loginIuser) {
		this.loginIuser = loginIuser;
	}
	public String getUnm() {
		return unm;
	}
	public void setUnm(String unm) {
		this.unm = unm;
	}
	public int getIboard() {
		return iboard;
	}
	public void setIboard(int iboard) {
		this.iboard = iboard;
	}
	public int getIuser() {
		return iuser;
	}
	public void setIuser(int iuser) {
		this.iuser = iuser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
}
