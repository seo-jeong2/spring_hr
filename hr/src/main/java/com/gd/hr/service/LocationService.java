package com.gd.hr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.DocumentationTool.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.hr.mapper.LocationMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Region;

@Service
public class LocationService implements ILocationService {
	@Autowired LocationMapper locationMapper;
	@Autowired RegionMapper regionMapper;

	@Override
	public int addLocation(Location location) {
		int row = locationMapper.insertLocation(location);
		return row;
	}

	@Override
	public Map<String, Object> addLocationForm() {
		Map<String,Object> resultMap = new HashMap<>();
		List<Region> regionList = regionMapper.selectRegionList();
		
		resultMap.put("regionList" , regionList);
		return resultMap;
	}

	@Override
	public List<Map<String, Object>> locationList() {
		// TODO Auto-generated method stub
		return locationMapper.selectLocationList();
	}
	
	

}
