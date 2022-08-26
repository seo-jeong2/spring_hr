package com.gd.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.ICountryService;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Controller
public class CountryController {
	@Autowired ICountryService countryService;
	
	//리스트
	@GetMapping("/countryList") //form
	public String countryList(Model model) {
		List<Map<String, Object>> countryList = countryService.countryList();
		
		model.addAttribute("countryList", countryList);
		return "countryList"; 
		//<select><c:foreach var="region" items="${regionList}"><option>
	
	}
	//삽입
	@GetMapping("/addCountry") //form
	public String addCountry(Model model) {
		List<Region> regionList = countryService.addCountryform();
		
		model.addAttribute("regionList", regionList);
		
		
		return "addCountry"; 
		
	}
	//삽입
	@PostMapping("/addCountry") //action
	public String addCountry(Country country) {
		System.out.println(country);
		
		int row = countryService.addCountry(country);
		System.out.println(row);
		return "redirect:/countryList"; //forward
	}
	
	//삭제
	@GetMapping("/removeCountry")
	public String removeCountry(@RequestParam(value="countryId") String countryId) {
		System.out.println(countryId + " <-- regionId");
		int row = countryService.removeCountry(countryId);
		System.out.println(row + "<--row");
		//regionList redirect
		return "redirect:/countryList"; 
	}
	@PostMapping("/removeCountry")

	
	//수정
	@GetMapping("/modifyCountry")
	public String modifyCountry(Model model, Country country) {
		model.addAttribute("c", country);
		System.out.println(model);
		
		return "redirect:/countryList";
	
	
	}
	

	
	@PostMapping("/modifyCountry")
	public String modifyCountry(Country country)  {
		int row = countryService.modifyCountry(country);
			System.out.println(row + ": row");
			
			return "redirect:/countryList";
	
	
}
	
	@GetMapping("/modifyCountry")
	public String modifyCountry(Model model, @RequestParam(value="countryId") String countryId) {
		
		Country country = countryService.getCountryOne(countryId);
		
		model.addAttribute("countryId", country.getCountryId());
		model.addAttribute("countryName", country.getCountryName());
		model.addAttribute("regionId", country.getRegionId());
		;
		
		System.out.println(model + " <-- model");
		
		return "modifyCountry";
	}
	
	
	
}
