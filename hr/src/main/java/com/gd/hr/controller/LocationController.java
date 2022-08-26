package com.gd.hr.controller;

import java.util.Map;

import javax.tools.DocumentationTool.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.hr.service.LocationService;

@Controller
public class LocationController {
	@Autowired LocationService locationService;
	
	@GetMapping("/addLocation") //form
	public String addLocation(Model model) {
		Map<String,Object> map = locationService.addLocationForm();
		model.addAttribute("regionList", map.get("regionList"));
		
		return "addLocation";
	}
	
	
	@PostMapping("/addLocation") //action
	public String addLocation(Location location) {
		int row = locationService.addLocation(location);
		System.out.println(row);
		return "redirect:/addLocation"; //forward
	
	}

}
