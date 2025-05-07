package com.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.myhome.dto.DataDto;
import com.myhome.dto.DefaultDto;

@Mapper
public interface DataMapper {

	// 자료등록
	int 	  	   insertData(DataDto dto);

	// 자료목록
	List<?> selectDataList(DefaultDto dft);
	
	// 자료개수
	int    selectDataTotal(DefaultDto dft);
	
	// 자료상세
	DataDto    selectDataDetail(int seqid);

	// 조회수증가
	void 		 updateDataHits(int seqid);
	
	// 파일이미지수정
	int    updateDataFileName(DataDto dto);

	// 자료수정
	int 		   updateData(DataDto dto);
	
	// 자료삭제
	int 		   deleteData(DataDto dto);
}
