package com.gd.hr.mapper;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Country;

@Mapper
public interface CountryMapper {
	
	int insertCountry(Country country);
	
	//Region이 포함된 테이블을 만들던지
	//합해서 사용할 수 있는 List<Map<String, Object>>사용
	
	
	List<Map<String,Object>> selectCountryList();
	
	int deleteCountryByRegionId (int regionid);
	
	int deleteCountry(String countryId);
	
	int updateCountry(Country country);
	
	Country selectCountryOne (String countryId);
	


	List<Country> selectCountryIdAndNameList(int regionId);


}
