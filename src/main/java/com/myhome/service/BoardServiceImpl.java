package com.myhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myhome.dto.BoardDto;
import com.myhome.mapper.BoardMapper;

@Service 
public class BoardServiceImpl implements BoardService {

	@Autowired 
	BoardMapper mapper;
	
	// 오버라이딩 (상속관계에서 부모클래스의 메소드를 재구성한다는 의미)
	
	//게시판 목록출력
	@Override 
	public List<?> selectBoardList(BoardDto dto) throws Exception {return mapper.selectBoardList(dto);}
	
	//게사판 입력처리
	@Override
	public int 		   insertBoard(BoardDto dto) throws Exception {return mapper.insertBoard(dto);}
	
	//게시판 수정처리
	@Override
	public int		   updateBoard(BoardDto dto) throws Exception {return mapper.updateBoard(dto);}
	
	//게시판 상세출력
	@Override
	public BoardDto selectBoardDetail(int seqid) throws Exception {return mapper.selectBoardDetail(seqid);}
	
	//게시판 조회수 증가처리 
	@Override
	public void 	  updateBoardHits(int seqid) throws Exception {		  mapper.updateBoardHits(seqid);}
	
	//게시판 삭제처리
	@Override
	public int 			  deleteBoard(int seqid) throws Exception {return mapper.deleteBoard(seqid);}
}
