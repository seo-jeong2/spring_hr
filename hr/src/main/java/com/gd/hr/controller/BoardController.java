package com.gd.hr.controller;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Patch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.hr.service.IBoardService;
import com.gd.hr.vo.BoardForm;

@Controller
public class BoardController {
	@Autowired
	IBoardService boardService;

	@GetMapping("/addBoard")
	public String addBoard() {
		return "addBoard";
		
	}
	
	
	@PostMapping("/addBoard") //action
	public String addBoard(Model model, BoardForm boardForm, HttpSession session) {
		
		String path = session.getServletContext().getRealPath("/upload");
		//request.getServletContext().getRealPath(null)
		boardService.addBoard(boardForm, path);
		
		return "redirect:/boardList";

	}

}
