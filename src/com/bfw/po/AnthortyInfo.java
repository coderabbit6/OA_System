package com.bfw.po;

 
public class AnthortyInfo {
	private Integer anthortyId;

	private Integer anthortyPid;

	private String anthortyName;

	private String anthortyDesc;

	private String anthortyUrl;

	/**
	 * 父类名称
	 */
	private String panthortyName;

	/**
	 * 标识是否选中
	 */
	private boolean checked = false;

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getPanthortyName() {
		return panthortyName;
	}

	public void setPanthortyName(String panthortyName) {
		this.panthortyName = panthortyName;
	}

	public Integer getAnthortyId() {
		return anthortyId;
	}

	public void setAnthortyId(Integer anthortyId) {
		this.anthortyId = anthortyId;
	}

	public Integer getAnthortyPid() {
		return anthortyPid;
	}

	public void setAnthortyPid(Integer anthortyPid) {
		this.anthortyPid = anthortyPid;
	}

	public String getAnthortyName() {
		return anthortyName;
	}

	public void setAnthortyName(String anthortyName) {
		this.anthortyName = anthortyName;
	}

	public String getAnthortyDesc() {
		return anthortyDesc;
	}

	public void setAnthortyDesc(String anthortyDesc) {
		this.anthortyDesc = anthortyDesc;
	}

	public String getAnthortyUrl() {
		return anthortyUrl;
	}

	public void setAnthortyUrl(String anthortyUrl) {
		this.anthortyUrl = anthortyUrl;
	}

	@Override
	public String toString() {
		return "AnthortyInfo [anthortyId=" + anthortyId + ", anthortyPid="
				+ anthortyPid + ", anthortyName=" + anthortyName
				+ ", anthortyDesc=" + anthortyDesc + ", anthortyUrl="
				+ anthortyUrl + "]";
	}

}