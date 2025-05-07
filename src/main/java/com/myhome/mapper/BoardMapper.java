package com.myhome.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.myhome.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//게시판 목록출력
	List<?> selectBoardList(BoardDto dto);

	//게사판 입력처리
	int 		insertBoard(BoardDto dto);
	
	//게시판 수정처리
	int 		updateBoard(BoardDto dto);

	//게시판 상세출력
	BoardDto selectBoardDetail(int seqid);

	//게시판 조회수 증가처리
	void       updateBoardHits(int seqid);

	//게시판 삭제처리
	int            deleteBoard(int seqid);
}
