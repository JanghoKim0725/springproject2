package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myhome.dto.MbrDto;
import com.myhome.mapper.MbrMapper;

@Service
public class MbrServiceImpl implements MbrService {
	
	// Mbrmapper와 연결
	@Autowired 
	MbrMapper mapper;
	
	// 회원저장처리
	@Override
	public int 	           insertMbr(MbrDto dto) throws Exception {return mapper.insertMbr(dto);}
	
	// 회원수정처리
	@Override
	public int 			   updateMbr(MbrDto dto) throws Exception {return mapper.updateMbr(dto);}	
	
	// 회원목록
	@Override
	public List<?>     selectMbrList(MbrDto dto) throws Exception {return mapper.selectMbrList(dto);}

	// Total 건수
	@Override
	public int        selectMbrTotal(MbrDto dto) throws Exception {return mapper.selectMbrTotal(dto);}

	// 상세보기
	@Override
	public MbrDto selectMbrDetail(String userid) throws Exception {return mapper.selectMbrDetail(userid);}

	// 삭제처리
	@Override
	public int          deleteMbr(String userid) throws Exception {return mapper.deleteMbr(userid);}
}
