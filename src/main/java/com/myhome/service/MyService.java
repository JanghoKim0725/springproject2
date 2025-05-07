package com.myhome.service;

import java.util.List;
import com.myhome.dto.DefaultDto;
import com.myhome.dto.MyboardDto;
import com.myhome.dto.ReboardDto;

public interface MyService {

	// 댓글게시판 목록
	List<?>   selectMyboardList(DefaultDto dft) throws Exception;
	
	// 댓글게시판 등록
	int 	     insertMyboard(MyboardDto dto)  throws Exception;
	
	// 댓글게시판 수정
	int 		  updateMyboard(MyboardDto dto) throws Exception;

	// 댓글게시판 총개수
	int     selectMyboardTotal(DefaultDto dft)  throws Exception;
	
	// 댓글게시판 상세보기
	MyboardDto  selectMyboardDetail(int seqid)  throws Exception;
	
	// 댓글게시판 삭제
	int 			   deleteMyboard(int seqid) throws Exception;
	
	// 댓글목록
	List<?> 	  selectReboardList(int seqid)  throws Exception;
	
	// 댓글등록
	int   		 insertReboard(ReboardDto rto)  throws Exception;
	
	// 댓글수정
	int   		 updateReboard(ReboardDto rto)  throws Exception;

	// 댓글암호확인
	int selectReboardPassCheck(ReboardDto rto)  throws Exception;
	
	// 댓글삭제
	int   		 deleteReboard(ReboardDto rto)  throws Exception;
	
	// 조회수증가
	void 		  updateMyboardHits(int seqid)  throws Exception;

	// 본글의 암호확인
	int    selectMyboardPassCnt(MyboardDto dto) throws Exception;

	// 하위댓글의 개수
	int 	  selectReboardPseqidCnt(int seqid) throws Exception;

	// 댓글이 1개라도 있을시 수정처리
	int 		   updateMyboardCmmt(int seqid) throws Exception;
}