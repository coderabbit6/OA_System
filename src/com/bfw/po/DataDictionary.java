package com.bfw.po;

public class DataDictionary {
    private Integer dataId;

    private String dataContent;


    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }


	@Override
	public String toString() {
		return "DataDictionary [dataId=" + dataId + ", dataContent="
				+ dataContent +"]";
	}
    
    
}