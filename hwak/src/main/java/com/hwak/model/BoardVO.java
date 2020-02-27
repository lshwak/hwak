package com.hwak.model;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int eno;
	private String esubject;
	private String econtent;
	private String edate;
	private String estyle;
	private String etype;
	private String eaddress;
	private String ewriter;
	private String ewrite_date;
	private int ecnt;
	private int ercm;
	//private MultipartFile files;		// file upload
	private String[] filename;
	private String fn;
	
	
	
	
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
