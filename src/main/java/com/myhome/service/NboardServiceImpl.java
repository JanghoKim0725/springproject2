package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;
import com.myhome.mapper.NboardMapper;

// 객체지향 4대요소 : 상속,다형성(오버라이딩),캡슐화,추상화

@Service
public class NboardServiceImpl implements NboardService {
	
	@Autowired
	NboardMapper mapper;
	
	// (게시판)저장처리
	@Override
	public int insertNboard(NboardDto dto) throws Exception {return mapper.insertNboard(dto);}
	
	// (게시판)수정처리
	@Override
	public int updateNboard(NboardDto dto) throws Exception {return mapper.updateNboard(dto);}
	
	// (게시판)목록
	@Override
	public List<?> selectNboardList(DefaultDto dft) throws Exception {return mapper.selectNboardList(dft);}
	
	// (게시판)Emsis
	@Override
	public List<?> selectNboardEmsisList(DefaultDto dft) throws Exception {
		return mapper.selectNboardEmsisList(dft);
	}		
	
	// (게시판) 총 데이터 개수
	@Override
	public int selectNboardTotal(DefaultDto dft) throws Exception {return mapper.selectNboardTotal(dft);}

	// (게시판) 상세보기
	@Override
	public NboardDto  selectNboardDetail(int seqid) throws Exception {
		return mapper.selectNboardDetail(seqid);
	}

	// (상세보기) 조회수 증가
	@Override
	public void updateNboardHits(int seqid) throws Exception {mapper.updateNboardHits(seqid);}

	// 암호확인
	@Override
	public int selectNboardPassCheck(NboardDto dto) throws Exception {
		return mapper.selectNboardPassCheck(dto);
	}
	
	// 삭제처리
	@Override
	public int deleteNboard(NboardDto dto) throws Exception {return mapper.deleteNboard(dto);}
}