package com.gd.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Mapper
public interface CountryMapper {
	
	int insertCountry(Country country);
	
	//Region이 포함된 테이블을 만들던지
	//합해서 사용할 수 있는 List<Map<String, Object>>사용
	//팀원들하고 회의끝에 통일하기로 했다.
	
	List<Map<String,Object>> selectCountryList();
	
	
	int deleteCountry (String countryId);
	
	int updateCountry (Country country);
	
	Country selectCountryOne (String countryId);
}
