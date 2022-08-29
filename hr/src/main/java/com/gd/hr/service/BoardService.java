package com.gd.hr.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.hr.mapper.BoardMapper;
import com.gd.hr.mapper.BoardfileMapper;
import com.gd.hr.vo.BoardForm;
import com.gd.hr.vo.Boardfile;

@Service
@Transactional
public class BoardService implements IBoardService {
	@Autowired BoardMapper boardMapper;
	@Autowired BoardfileMapper boardfileMapper;
	
	@Override
	public void addBoard(BoardForm boardForm, String path) {
		System.out.println(boardForm.getBoard().getBoardNo()); // board.getBoarNo() --> 0
		int row = boardMapper.insertBoard(boardForm.getBoard());
		System.out.println(boardForm.getBoard().getBoardNo()); // board.getBoarNo() --> selectKey
		
		// boardfile insert
		if(row==1 && boardForm.getMultiList() != null) {
			for(MultipartFile mf : boardForm.getMultiList()) {
				Boardfile boardfile = new Boardfile();
				boardfile.setBoardNo(boardForm.getBoard().getBoardNo());
				// 중복되지 않는 랜덤이름 새성 UUID API사용
				String filename = UUID.randomUUID().toString().replace("-", "");
				
				boardfile.setFilename(filename);
				boardfile.setOriginName(mf.getOriginalFilename());
				boardfile.setFileType(mf.getContentType());
				boardfile.setFileSize(mf.getSize());
				boardfileMapper.insertBoardfile(boardfile);
				
				//text.txt
				String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf(".")); //파일 확장자
				
				//throws 하면 아무것도 발생하지 않음
				try {
					//새로운 빈파일안에 MultipartFile안에 파일을 하나씩 복사
					mf.transferTo(new File(path+filename+ext));
					
				} catch (Exception e) {
					e.printStackTrace();
					
					//throw catch를 발생시키지 않는 runtimeException만듬
					//트랜잭션 처리가 되도록 강제로 Runtime예외(try절을 강요하지않는) 발생
					throw new RuntimeException();
				}
			}
		}
	}
}

