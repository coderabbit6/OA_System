package com.bfw.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.po.AnthortyInfo;
import com.bfw.system.mapper.AnthortyInfoMapper;
import com.bfw.system.mapper.RoleAnthorityInfoMapper;
import com.bfw.system.service.AnthortyService;

@Service
public class AnthortyServiceImpl implements AnthortyService {

	/**
	 * 权限信息
	 */
	@Resource(name = "anthortyInfoMapper")
	private AnthortyInfoMapper anthortyInfoMapper;

	/**
	 * 角色权限信息
	 */
	@Resource(name = "roleAnthorityInfoMapper")
	private RoleAnthorityInfoMapper roleAnthorityInfoMapper;

	@Override
	public List<AnthortyInfo> getList() {
		// TODO Auto-generated method stub
		return anthortyInfoMapper.getAnthortyInfoList(null);
	}

	@Override
	public AnthortyInfo getAnthortyInfo(Integer anthortyId) {

		return anthortyInfoMapper.selectByPrimaryKey(anthortyId);
	}

	@Override
	public boolean add(AnthortyInfo anth) {

		try {
			int count = anthortyInfoMapper.insertSelective(anth);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(AnthortyInfo anth) {

		try {

			int count = anthortyInfoMapper.updateByPrimaryKeySelective(anth);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void delete(Integer anthortyId) throws Exception {
		if (anthortyId != null) {
			// 先删除外键关联的表信息
			roleAnthorityInfoMapper.deleteByAnthortyId(anthortyId);
			anthortyInfoMapper.deleteByPrimaryKey(anthortyId);
		}

	}

	@Override
	public boolean isDelete(Integer anthortyId) {

		try {
			if (anthortyId != null) {
				AnthortyInfo anth = new AnthortyInfo();
				anth.setAnthortyId(anthortyId);
					
				List list = anthortyInfoMapper.getAnthortyInfoList(anth);
			
				if(list!=null&&list.size()>0){
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return true;
	}

	@Override
	public List<AnthortyInfo> getAnthList(Integer roleId) {
		// TODO Auto-generated method stub
		return anthortyInfoMapper.getAnthortyByRoleIdList(roleId);
	}

}
