package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import javax.tools.DocumentationTool.Location;

public interface ILocationService {
	
	int addLocation(Location location);
	
	Map<String,Object> addLocationForm();
	
	List<Map<String,Object>> locationList();
	

}
