package com.gd.hr.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Board;

@Mapper
public interface BoardMapper {
	int insertBoard(Board board);
	
	

}
