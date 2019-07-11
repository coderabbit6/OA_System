package com.bfw.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.po.AnthortyInfo;
import com.bfw.po.StaffInfo;
import com.bfw.system.dto.ReportInfo;
import com.bfw.system.mapper.StaffInfoMapper;
import com.bfw.system.service.StaffInfoService;

@Service
public class StaffInfoServiceImpl implements StaffInfoService {

	@Resource(name = "staffInfoMapper")
	private StaffInfoMapper staffInfoMapper;

	@Override
	public boolean addStaff(StaffInfo staff) {
		
		try {
			int i = staffInfoMapper.insertSelective(staff);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public List<StaffInfo> getList(StaffInfo staff) {
	
		return staffInfoMapper.getStaffInfoList(staff);
	}

	@Override
	public StaffInfo getStaffInfo(Integer staffId) {
		
		return staffInfoMapper.selectByPrimaryKey(staffId);
	}

	@Override
	public boolean updateStaff(StaffInfo staff) {
		try {
			int i = staffInfoMapper.updateByPrimaryKeySelective(staff);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean 	deleteStaff(StaffInfo staff) {
		try {
			int i = staffInfoMapper.deleteByPrimaryKey(staff.getStaffId());
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<StaffInfo> getStaffList(StaffInfo staff) {
		
		return staffInfoMapper.getStaffList(staff);
	}
	
	@Override
	public ReportInfo getReportInfo() {
		ReportInfo info = new ReportInfo();
		
		
		info.setSateList(staffInfoMapper.getSateList());
		
		System.out.println(info.getSateList());
		
		return info;
	}


}
