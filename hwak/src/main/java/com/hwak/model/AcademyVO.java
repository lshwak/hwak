package com.hwak.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class AcademyVO {
	
	private String aname;	// 학원명
	private String atype;	// 전문분야
	private String amaster;	// 대표자
	private String aarea;	// 지역
	private String acontent;// 소개내용
	private String awriter;	// 작성자
	private Date aregdate;	// 작성일
	private int ano;		// 번호
	private int acnt;		// 조회수
	private int arcm;		// 추천수
	private MultipartFile aimage;//이미지
	
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public String getAmaster() {
		return amaster;
	}
	public void setAmaster(String amaster) {
		this.amaster = amaster;
	}
	public String getAarea() {
		return aarea;
	}
	public void setAarea(String aarea) {
		this.aarea = aarea;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAwriter() {
		return awriter;
	}
	public void setAwriter(String awriter) {
		this.awriter = awriter;
	}
	public Date getAregdate() {
		return aregdate;
	}
	public void setAregdate(Date aregdate) {
		this.aregdate = aregdate;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getAcnt() {
		return acnt;
	}
	public void setAcnt(int acnt) {
		this.acnt = acnt;
	}
	public int getArcm() {
		return arcm;
	}
	public void setArcm(int arcm) {
		this.arcm = arcm;
	}
	public MultipartFile getAimage() {
		return aimage;
	}
	public void setAimage(MultipartFile aimage) {
		this.aimage = aimage;
	}
	
	@Override
	public String toString() {
		return "AcademyVO [aname=" + aname + ", atype=" + atype + ", amaster=" + amaster + ", aarea=" + aarea
				+ ", acontent=" + acontent + ", awriter=" + awriter + ", aregdate=" + aregdate + ", ano=" + ano
				+ ", acnt=" + acnt + ", arcm=" + arcm + ", aimage=" + aimage + "]";
	}
	
}
