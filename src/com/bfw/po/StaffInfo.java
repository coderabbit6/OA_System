package com.bfw.po;

import java.util.Date;
import com.bfw.po.DataDictionary;
import com.bfw.system.service.DataDictionaryService;
/**
 * 员工的实体类
 * 
 * @author laoliu
 *
 */
public class StaffInfo {
	private Integer staffId;

	private Integer roleId;

	private String staffName;

	private String staffSex;

	private Integer staffAge;

	private String staffNativePlace;

	private String staffIdcard;

	private Date staffBrithday;

	private String staffOfficePhone;

	private String staffMobilePhone;

	private String staffEamil;

	private String staffAddr;

	private String staffQq;

	private Date staffEntryTime;

	private String staffEductionLevel;

	private String staffRemark;

	private String staffState;

	private String userNumber;

	private String userPassowrd;

	private String roleName;

	
	private Integer dataId;
	private String dataName;
	

	public Integer getDataId() {
		return dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffSex() {
		return staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	public Integer getStaffAge() {
		return staffAge;
	}

	public void setStaffAge(Integer staffAge) {
		this.staffAge = staffAge;
	}

	public String getStaffNativePlace() {
		return staffNativePlace;
	}

	public void setStaffNativePlace(String staffNativePlace) {
		this.staffNativePlace = staffNativePlace;
	}

	public String getStaffIdcard() {
		return staffIdcard;
	}

	public void setStaffIdcard(String staffIdcard) {
		this.staffIdcard = staffIdcard;
	}

	public Date getStaffBrithday() {
		return staffBrithday;
	}

	public void setStaffBrithday(Date staffBrithday) {
		this.staffBrithday = staffBrithday;
	}

	public String getStaffOfficePhone() {
		return staffOfficePhone;
	}

	public void setStaffOfficePhone(String staffOfficePhone) {
		this.staffOfficePhone = staffOfficePhone;
	}

	public String getStaffMobilePhone() {
		return staffMobilePhone;
	}

	public void setStaffMobilePhone(String staffMobilePhone) {
		this.staffMobilePhone = staffMobilePhone;
	}

	public String getStaffEamil() {
		return staffEamil;
	}

	public void setStaffEamil(String staffEamil) {
		this.staffEamil = staffEamil;
	}

	public String getStaffAddr() {
		return staffAddr;
	}

	public void setStaffAddr(String staffAddr) {
		this.staffAddr = staffAddr;
	}

	public String getStaffQq() {
		return staffQq;
	}

	public void setStaffQq(String staffQq) {
		this.staffQq = staffQq;
	}

	public Date getStaffEntryTime() {
		return staffEntryTime;
	}

	public void setStaffEntryTime(Date staffEntryTime) {
		this.staffEntryTime = staffEntryTime;
	}

	public String getStaffEductionLevel() {
		return staffEductionLevel;
	}

	public void setStaffEductionLevel(String staffEductionLevel) {
		this.staffEductionLevel = staffEductionLevel;
	}

	public String getStaffRemark() {
		return staffRemark;
	}

	public void setStaffRemark(String staffRemark) {
		this.staffRemark = staffRemark;
	}

	public String getStaffState() {
		return staffState;
	}

	public void setStaffState(String staffState) {
		this.staffState = staffState;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserPassowrd() {
		return userPassowrd;
	}

	public void setUserPassowrd(String userPassowrd) {
		this.userPassowrd = userPassowrd;
	}

	@Override
	public String toString() {
		return "StaffInfo [staffId=" + staffId + ", roleId=" + roleId
				+ ", staffName=" + staffName + ", staffSex=" + staffSex
				+ ", staffAge=" + staffAge + ", staffNativePlace="
				+ staffNativePlace + ", staffIdcard=" + staffIdcard
				+ ", staffBrithday=" + staffBrithday + ", staffOfficePhone="
				+ staffOfficePhone + ", staffMobilePhone=" + staffMobilePhone
				+ ", staffEamil=" + staffEamil + ", staffAddr=" + staffAddr
				+ ", staffQq=" + staffQq + ", staffEntryTime=" + staffEntryTime
				+ ", staffEductionLevel=" + staffEductionLevel
				+ ", staffRemark=" + staffRemark + ", staffState=" + staffState
				+ ", userNumber=" + userNumber + ", userPassowrd="
				+ userPassowrd + "]";
	}

}