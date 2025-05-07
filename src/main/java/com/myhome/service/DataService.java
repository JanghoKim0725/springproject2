package com.myhome.service;

import java.util.List;

import com.myhome.dto.DataDto;
import com.myhome.dto.DefaultDto;

public interface DataService {
	
	// 자료등록
	int 	  	   		insertData(DataDto dto) throws Exception;
	
	// 자료목록
	List<?> 	 selectDataList(DefaultDto dft) throws Exception;
	
	// 자료개수
	int    		selectDataTotal(DefaultDto dft) throws Exception;

	// 자료상세
	DataDto    		selectDataDetail(int seqid) throws Exception;
	
	// 조회수증가
	void 		 	  updateDataHits(int seqid) throws Exception;

	// 파일이미지수정
	int 		updateDataFileName(DataDto dto) throws Exception;
	
	// 자료수정
	int 				updateData(DataDto dto) throws Exception;
	
	// 자료삭제
	int 				deleteData(DataDto dto) throws Exception;
	
}
