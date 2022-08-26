package com.gd.hr.mapper;

import javax.tools.DocumentationTool.Location;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationMapper {
	
	int insertLocation (Location location);
	
	
	
	

}
