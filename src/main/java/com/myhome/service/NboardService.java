package com.myhome.service;

import java.util.List;
import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;

public interface NboardService {
	
	// (게시판)저장처리 insert ~~~ => 건수
	int 		 	  insertNboard(NboardDto dto) throws Exception;
	
	// (게시판)수정처리 update ~~~ => 건수
	int 			  updateNboard(NboardDto dto) throws Exception;
	
	// (게시판)목록
	List<?> 	 selectNboardList(DefaultDto dft) throws Exception;

	// (게시판)Emsis
	List<?> selectNboardEmsisList(DefaultDto dft) throws Exception;
	
	// (게시판) 총 데이터 개수
	int    		selectNboardTotal(DefaultDto dft) throws Exception;
	
	// (게시판) 상세보기
	NboardDto  		selectNboardDetail(int seqid) throws Exception;

	//(상세보기) 조회수 증가
	void 			  updateNboardHits(int seqid) throws Exception;

	// 암호확인
	int 	 selectNboardPassCheck(NboardDto dto) throws Exception;
	
	// 삭제처리
	int 			  deleteNboard(NboardDto dto) throws Exception;
}
