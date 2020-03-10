package com.hwak.model;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class MagazineVO {
	
	private int mno; // 번호
	private String mtitle; // 제목
	private String msubtitle; // 부제
	private String mtype; // 타입
	private Date mregdate;// 날짜
	private String mcontent; // 내용
	private String mwriter; // 작성자
	private int mcnt; // 조회
	private int mrcm; // 추천
	private String[] mimage; // 이미지
	private String fn;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMsubtitle() {
		return msubtitle;
	}
	public void setMsubtitle(String msubtitle) {
		this.msubtitle = msubtitle;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public Date getMregdate() {
		return mregdate;
	}
	public void setMregdate(Date mregdate) {
		this.mregdate = mregdate;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public String getMwriter() {
		return mwriter;
	}
	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}
	public int getMcnt() {
		return mcnt;
	}
	public void setMcnt(int mcnt) {
		this.mcnt = mcnt;
	}
	public int getMrcm() {
		return mrcm;
	}
	public void setMrcm(int mrcm) {
		this.mrcm = mrcm;
	}
	public String[] getMimage() {
		return mimage;
	}
	public void setMimage(String[] mimage) {
		this.mimage = mimage;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	@Override
	public String toString() {
		return "MagazineVO [mno=" + mno + ", mtitle=" + mtitle + ", msubtitle=" + msubtitle + ", mtype=" + mtype
				+ ", mregdate=" + mregdate + ", mcontent=" + mcontent + ", mwriter=" + mwriter + ", mcnt=" + mcnt
				+ ", mrcm=" + mrcm + ", mimage=" + Arrays.toString(mimage) + ", fn=" + fn + "]";
	}
	
}
