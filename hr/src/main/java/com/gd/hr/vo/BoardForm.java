package com.gd.hr.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardForm {
	private Board board; // <input name="board.boardNo"
	private List<MultipartFile> multiList;
}
