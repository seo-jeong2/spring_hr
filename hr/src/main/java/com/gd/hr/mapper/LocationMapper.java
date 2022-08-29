package com.gd.hr.mapper;

import java.util.List;
import java.util.Map;

import javax.tools.DocumentationTool.Location;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationMapper {
	
	int insertLocation (Location location);
	
	
	List<Map<String,Object>> selectLocationList();
	

}
