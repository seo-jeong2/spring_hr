package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.hr.mapper.CountryMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Service
public class CountryService implements ICountryService {
	@Autowired CountryMapper countryMapper;
	@Autowired RegionMapper regionMapper;
	

	@Override
	public int addCountry(Country country) {
		// TODO Auto-generated method stub
		return countryMapper.insertCountry(country);
	}

	@Override
	public List<Map<String, Object>> countryList() {
		// TODO Auto-generated method stub
		return countryMapper.selectCountryList();
	}

	@Override
	public List<Region> addCountryform() {
		// TODO Auto-generated method stub
		return regionMapper.selectRegionList();
	}

	@Override
	public int removeCountry(String CountryId) {
		// TODO Auto-generated method stub
		return countryMapper.deleteCountry(CountryId);
	}

	@Override
	public int modifyCountry(Country country) {
		// TODO Auto-generated method stub
		return countryMapper.updateCountry(country);
	}

	@Override
	public Country getCountryOne(String countryId) {
		// TODO Auto-generated method stub
		return countryMapper.selectCountryOne(countryId);
	}


	

}
