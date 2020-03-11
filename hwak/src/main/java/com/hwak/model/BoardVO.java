package com.hwak.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int eno;
	private String esubject; // 행사명
	private String econtent; // 내용
	private String edate; // 행사날짜
	private String estyle; // 장르
	private String etype; // 행사 타입
	private String eaddress; // 행사장
	private String ewriter; // 작성자
	private String ewrite_date; // 작성일
	private int ecnt; // 조회수
	private int ercm; // 추처누
	//private MultipartFile files;		// file upload
	private String[] filename; // 포스터를 여러장 올리기 위해 String배열
	private String fn; // 썸네일로 담을 공간
	
	
	
	
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	
	public String[] getFilename() {
		return filename;
	}
	public void setFilename(String[] filename) {
		this.filename = filename;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEsubject() {
		return esubject;
	}
	public void setEsubject(String esubject) {
		this.esubject = esubject;
	}
	public String getEcontent() {
		return econtent;
	}
	public void setEcontent(String econtent) {
		this.econtent = econtent;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getEstyle() {
		return estyle;
	}
	public void setEstyle(String estyle) {
		this.estyle = estyle;
	}
	public String getEtype() {
		return etype;
	}
	public void setEtype(String etype) {
		this.etype = etype;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEwriter() {
		return ewriter;
	}
	public void setEwriter(String ewriter) {
		this.ewriter = ewriter;
	}
	public String getEwrite_date() {
		return ewrite_date;
	}
	public void setEwrite_date(String ewrite_date) {
		this.ewrite_date = ewrite_date;
	}
	public int getEcnt() {
		return ecnt;
	}
	public void setEcnt(int ecnt) {
		this.ecnt = ecnt;
	}
	public int getErcm() {
		return ercm;
	}
	public void setErcm(int ercm) {
		this.ercm = ercm;
	}

	/*
	 * public MultipartFile getFiles() { return files; } public void
	 * setFiles(MultipartFile files) { this.files = files; }
	 */
	
	
	@Override
	public String toString() {
		return "BoardVO [eno=" + eno + ", esubject=" + esubject + ", econtent=" + econtent + ", edate=" + edate
				+ ", estyle=" + estyle + ", etype=" + etype + ", eaddress=" + eaddress + ", ewriter=" + ewriter
				+ ", ewrite_date=" + ewrite_date + ", ecnt=" + ecnt + ", ercm=" + ercm + ", filename=" + filename + "]";
	}
	
	
	
}
