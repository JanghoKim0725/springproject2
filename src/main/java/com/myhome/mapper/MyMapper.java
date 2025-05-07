package com.myhome.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.myhome.dto.DefaultDto;
import com.myhome.dto.MyboardDto;
import com.myhome.dto.ReboardDto;

@Mapper
public interface MyMapper {
	
	// 댓글게시판 목록
	List<?>  selectMyboardList(DefaultDto dft);
	
	// 댓글게시판 등록
	int 		 insertMyboard(MyboardDto dto);
	
	// 댓글게시판 수정
	int 		 updateMyboard(MyboardDto dto);

	// 댓글게시판 총개수
	int     selectMyboardTotal(DefaultDto dft);

	// 댓글게시판 상세보기
	MyboardDto  selectMyboardDetail(int seqid);
	
	// 댓글게시판 삭제
	int 			  deleteMyboard(int seqid);
	
	// 댓글목록
	List<?> 	  selectReboardList(int seqid);
	
	// 댓글등록
	int 		 insertReboard(ReboardDto rto);
	
	// 댓글수정
	int 		 updateReboard(ReboardDto rto);
	
	// 댓글암호확인
	int selectReboardPassCheck(ReboardDto rto);	
	
	// 댓글삭제
	int 		 deleteReboard(ReboardDto rto);

	// 조회수증가
	void 		  updateMyboardHits(int seqid);

	// 본글의 암호확인
	int   selectMyboardPassCnt(MyboardDto dto);

	// 하위댓글의 개수
	int 	 selectReboardPseqidCnt(int seqid);

	// 댓글이 1개라도 있을시 수정처리
	int 		  updateMyboardCmmt(int seqid);
}