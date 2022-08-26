package com.gd.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.CountryMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Region;

@Service
@Transactional
public class RegionService implements IRegionService {
	//DI : 객체를 직접 생성하지 않고 스프링 프레임워크를 통해(bean객체) 주입
	//Interface 타입을 사용
	@Autowired RegionMapper regionMapper;
	@Autowired CountryMapper countryMapper;
	
	@Override
	public List<Region> getRegionList() {
		
		return regionMapper.selectRegionList();
	}

	@Override
	public int addRegion(Region region) {
		
		return regionMapper.insertRegion(region);
	}

	@Override
	public int removeRegion(int regionId)  {
		countryMapper.deleteCountryByRegionId(regionId);
		int row = regionMapper.deleteRegion(regionId);

		return row;
		
	}

	@Override
	public int modifyRegion(Region region) {
		return regionMapper.updateRegion(region);
	}

	@Override
	public Region getRegion(int regionId) {
		return regionMapper.selectRegionOne(regionId);
	}

	
class MybatisException extends RuntimeException {
	
}
	
	
}