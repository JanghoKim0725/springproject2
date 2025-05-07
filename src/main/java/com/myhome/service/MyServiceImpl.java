package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myhome.dto.DefaultDto;
import com.myhome.dto.MyboardDto;
import com.myhome.dto.ReboardDto;
import com.myhome.mapper.MyMapper;

@Service
public class MyServiceImpl implements MyService {
	
	@Autowired
	MyMapper mapper;
	
	// 댓글게시판 목록
	@Override
	public List<?> selectMyboardList(DefaultDto dft) throws Exception {
		return mapper.selectMyboardList(dft);
	}
	
	// 댓글게시판 등록
	@Override
	public int insertMyboard(MyboardDto dto) throws Exception {return mapper.insertMyboard(dto);}

	// 댓글게시판 수정
	@Override
	public int updateMyboard(MyboardDto dto) throws Exception {return mapper.updateMyboard(dto);}
	
	// 댓글게시판 총개수
	@Override
	public int selectMyboardTotal(DefaultDto dft) throws Exception {return mapper.selectMyboardTotal(dft);}

	// 댓글게시판 상세보기
	@Override
	public MyboardDto selectMyboardDetail(int seqid) throws Exception {
		return mapper.selectMyboardDetail(seqid);
	}
	
	// 댓글게시판 삭제
	@Override
	public int deleteMyboard(int seqid) throws Exception {return mapper.deleteMyboard(seqid);}

	// 댓글목록
	@Override
	public List<?> selectReboardList(int seqid) throws Exception {return mapper.selectReboardList(seqid);}

	// 댓글등록
	@Override
	public int insertReboard(ReboardDto rto) throws Exception {return mapper.insertReboard(rto);}
	
	// 댓글수정
	@Override
	public int updateReboard(ReboardDto rto) throws Exception {return mapper.updateReboard(rto);}
	
	// 댓글암호확인
	@Override
	public int selectReboardPassCheck(ReboardDto rto) throws Exception {
		return mapper.selectReboardPassCheck(rto);
	}
	
	// 댓글삭제
	@Override
	public int deleteReboard(ReboardDto rto) throws Exception {return mapper.deleteReboard(rto);}	
	
	// 조회수증가
	@Override
	public void updateMyboardHits(int seqid) throws Exception {mapper.updateMyboardHits(seqid);}

	// 본글의 암호확인
	@Override
	public int selectMyboardPassCnt(MyboardDto dto) throws Exception {
		return mapper.selectMyboardPassCnt(dto);
	}

	// 하위댓글의 개수
	@Override
	public int selectReboardPseqidCnt(int seqid) throws Exception {
		return mapper.selectReboardPseqidCnt(seqid);
	}
	
	// 댓글이 1개라도 있을시 수정처리
	@Override
	public int updateMyboardCmmt(int seqid) throws Exception {return mapper.updateMyboardCmmt(seqid);}
}