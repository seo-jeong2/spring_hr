package com.gd.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.IRegionService;
import com.gd.hr.vo.Region;

//객체만들어주고 servlet사용가능
@Controller
public class RegionController {
	//new RegionService
	@Autowired IRegionService regionService;
	
	@GetMapping("/regionList")
	public String regionList(Model model) {
		List<Region> list = regionService.getRegionList();
		//request.setAttribute("list",list);
		model.addAttribute("list",list);
		
		System.out.println(list);
		//("regionList").forward(request,response);
		return "regionList";
	}
	
	
	//Form
	@GetMapping("/addRegion") 
	public String addRegion() {
		return "addRegion";
	}
	
	
	//Action
	@PostMapping("/addRegion") 
	
	//오버로딩
	
	//int regionId = request.getParameter("regionId")
	//defaultValue="1"
	//public String addRegion(@RequestParam(value = "regionId", defaultValue="1") int regionId) {
	//form만들때 네임을 같게 해줘야된다.
	public String addRegion(Region region) {
		System.out.println(region);
		
		int row = regionService.addRegion(region);
		System.out.println(row + "<--row");
		
		return "redirect:/regionList"; //regionList redirect
	}
	
	//required="false" null값 허용
	@GetMapping("/removeRegion")
	public String removeRegion(@RequestParam(value="regionId") int regionId) {
		System.out.println(regionId + " <-- regionId");
		int row = regionService.removeRegion(regionId);
		System.out.println(row + "<--row");
		//regionList redirect
		return "redirect:/regionList"; 
	}
	@PostMapping("/removeRegion")
	
	
	@GetMapping("/modifyRegion")
	//형변환 해줌
	public String modifyRegion(Model model, Region region) {
		model.addAttribute("r", region);
		System.out.println(model + " <-- model");
		System.out.println(region + " <-- region");
		
		return "redirect:/regionList";
	}
	
	@PostMapping("/modifyRegion")
	public String modifyRegion(Region region) {
		
		int row = regionService.modifyRegion(region);
		
		System.out.println(row + " <-- row");
		
		return "redirect:/regionList";
	}
	
	@GetMapping("/modifyRegion")
	public String modifyRegion(Model model, @RequestParam(value="regionId") int regionId) {
		
		Region region = regionService.getRegion(regionId);
		
		model.addAttribute("regionId", region.getRegionId());
		model.addAttribute("regionName", region.getRegionName());
		
		System.out.println(model + " <-- model");
		
		return "modifyRegion";
	}
	

}
