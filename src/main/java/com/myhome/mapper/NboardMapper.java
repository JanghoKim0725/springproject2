package com.myhome.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;

@Mapper
public interface NboardMapper {

	// (게시판)저장처리
	int 		  	  insertNboard(NboardDto dto);
	
	// (게시판)수정처리
	int 			  updateNboard(NboardDto dto);
	
	// (게시판)목록
	List<?> 	 selectNboardList(DefaultDto dft);

	// (게시판)Emsis
	List<?> selectNboardEmsisList(DefaultDto dft);
	
	// (게시판) 총 데이터 개수
	int 		selectNboardTotal(DefaultDto dft);

	// (게시판) 상세보기
	NboardDto 		selectNboardDetail(int seqid);

	// (상세보기) 조회수 증가
	int 			  updateNboardHits(int seqid);
	
	// 암호확인
	int 	 selectNboardPassCheck(NboardDto dto);
	
	// 삭제처리
	int 			  deleteNboard(NboardDto dto);
}