package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.dto.DataDto;
import com.myhome.dto.DefaultDto;
import com.myhome.mapper.DataMapper;

@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	DataMapper mapper;
	
	// 자료등록
	@Override
	public int insertData(DataDto dto) throws Exception {return mapper.insertData(dto);}
	
	// 자료목록
	@Override
	public List<?> selectDataList(DefaultDto dft) throws Exception {
		return mapper.selectDataList(dft);
	}

	// 자료개수
	@Override
	public int selectDataTotal(DefaultDto dft) throws Exception {
		return mapper.selectDataTotal(dft);
	}

	// 자료상세
	@Override
	public DataDto selectDataDetail(int seqid) throws Exception {
		return mapper.selectDataDetail(seqid);
	}
	
	// 조회수증가
	@Override
	public void updateDataHits(int seqid) throws Exception {mapper.updateDataHits(seqid);}

	// 파일이미지수정
	@Override
	public int updateDataFileName(DataDto dto) throws Exception {return mapper.updateDataFileName(dto);}

	// 자료수정
	@Override
	public int updateData(DataDto dto) throws Exception {return mapper.updateData(dto);}

	// 자료삭제
	@Override
	public int deleteData(DataDto dto) throws Exception {return mapper.deleteData(dto);}
}
