package com.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myhome.dto.MbrDto;

@Mapper
public interface MbrMapper {

	// 회원저장처리
	int             insertMbr(MbrDto dto);
	
	// 회원수정처리
	int 			updateMbr(MbrDto dto);

	// 회원목록
	List<?>     selectMbrList(MbrDto dto);

	// Total 건수
	int        selectMbrTotal(MbrDto dto);

	// 상세보기
	MbrDto selectMbrDetail(String userid);

	// 삭제처리
	int 		 deleteMbr(String userid);
}
