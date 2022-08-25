package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

public interface ICountryService {
	
	List<Map<String,Object>> countryList();
	
	int addCountry(Country country);
	
	List<Region> addCountryform();
	
	int removeCountry(String countryId);
	
	int modifyCountry(Country country);
	
	Country getCountryOne(String countryId);
	
}

	
