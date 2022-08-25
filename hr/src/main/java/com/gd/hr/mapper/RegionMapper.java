package com.gd.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Region;

//@Repository public class XXX RegionMapper {}
@Mapper
public interface RegionMapper {
	List<Region> selectRegionList();
	int insertRegion(Region region);
	int deleteRegion(int regionId);
	
	int updateRegion(Region region);
	
	Region selectRegionOne(int regionId);
}
