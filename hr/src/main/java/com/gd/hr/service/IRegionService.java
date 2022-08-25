package com.gd.hr.service;

import java.util.List;

import com.gd.hr.vo.Region;

public interface IRegionService {
	List<Region> getRegionList();
	
	int addRegion(Region region);
	
	int removeRegion(int regionId);
	
	int modifyRegion(Region region);
	
	Region getRegion(int regionId);
}
