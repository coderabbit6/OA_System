package com.bfw.po;

import java.util.Date;

public class informActive {
    private Integer activeId;

    private Integer staffId;

    private String activeName;

    private Integer activeState;

    private Date activeStart;

    private Date activeEnd;

    private Integer activeType;

    private Double activeCosteEmtimate;

    private Double activeCoste;

    private Integer activeRefectEstimate;

    private String activeStudent;

    private String activeContent;
    
    private String staffName;
    
    private String dataContent;
    

    public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getDataContent() {
		return dataContent;
	}

	public void setDataContent(String dataContent) {
		this.dataContent = dataContent;
	}

	public Integer getActiveId() {
        return activeId;
    }

    public void setActiveId(Integer activeId) {
        this.activeId = activeId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public Integer getActiveState() {
        return activeState;
    }

    public void setActiveState(Integer activeState) {
        this.activeState = activeState;
    }

    public Date getActiveStart() {
        return activeStart;
    }

    public void setActiveStart(Date activeStart) {
        this.activeStart = activeStart;
    }

    public Date getActiveEnd() {
        return activeEnd;
    }

    public void setActiveEnd(Date activeEnd) {
        this.activeEnd = activeEnd;
    }

    public Integer getActiveType() {
        return activeType;
    }

    public void setActiveType(Integer activeType) {
        this.activeType = activeType;
    }

    public Double getActiveCosteEmtimate() {
        return activeCosteEmtimate;
    }

    public void setActiveCosteEmtimate(Double activeCosteEmtimate) {
        this.activeCosteEmtimate = activeCosteEmtimate;
    }

    public Double getActiveCoste() {
        return activeCoste;
    }

    public void setActiveCoste(Double activeCoste) {
        this.activeCoste = activeCoste;
    }

    public Integer getActiveRefectEstimate() {
        return activeRefectEstimate;
    }

    public void setActiveRefectEstimate(Integer activeRefectEstimate) {
        this.activeRefectEstimate = activeRefectEstimate;
    }

    public String getActiveStudent() {
        return activeStudent;
    }

    public void setActiveStudent(String activeStudent) {
        this.activeStudent = activeStudent;
    }

    public String getActiveContent() {
        return activeContent;
    }

    public void setActiveContent(String activeContent) {
        this.activeContent = activeContent;
    }
}