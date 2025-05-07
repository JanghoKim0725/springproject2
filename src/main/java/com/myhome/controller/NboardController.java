package com.myhome.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;
import com.myhome.service.NboardService;

@Controller
public class NboardController {

	@Autowired
	NboardService nboardService;
	
	@GetMapping("nboardWrite")
	public String boardWrite() {return "board/nboardWrite";}
	
	@GetMapping("passWrite/{seqid}")
	public String passWrite(@PathVariable int seqid,ModelMap model) {
		
		model.addAttribute("seqid",seqid);
		return "board/passWrite";
	}
	
	
	@GetMapping("nboardModify/{seqid}")
	public String selectNboardModify(@PathVariable int seqid,ModelMap model) throws Exception {
		
		NboardDto dto = nboardService.selectNboardDetail(seqid);
		model.addAttribute("dto",dto);
		return "board/nboardModify";
	}
	
	@PostMapping("nboardInsert")
	@ResponseBody // -> return 값을 일반 jsp 경로가 아닌 일반 텍스트로
	public String insertNboard(NboardDto dto) throws Exception {
		
		//저장서비스 실행
		String message = "ok";
		int result = nboardService.insertNboard(dto);
		if( result == 0) message = "fail";
		return message;
	}
	
	@PostMapping("nboardUpdate")
	@ResponseBody // -> return 값을 일반 jsp 경로가 아닌 일반 텍스트로
	public String updateNboard(NboardDto dto) throws Exception {
		
		String message = "1";
		
		//암호확인
		int cnt = nboardService.selectNboardPassCheck(dto);
		if( cnt == 0) message = "2"; //암호를 잘못 입력한 경우
		else {
			//수정서비스 실행
			int result = nboardService.updateNboard(dto);
			if( result == 0) message = "4";
		}
		return message;
	}
	
	@PostMapping("nboardDelete")
	@ResponseBody
	public String deleteNboard(NboardDto dto) throws Exception {
		
		String message = "1";
		
		//암호확인 서비스
		int cnt = nboardService.selectNboardPassCheck(dto);
		if( cnt == 0) message = "2"; //암호를 잘못 입력한 경우
		else {
			//삭제서비스 실행
			int result = nboardService.deleteNboard(dto);
			if( result == 0) message = "4";
		}
		return message;
	}
	
	@GetMapping("nboardList")
	public String selectNboardList(DefaultDto dft,ModelMap model) throws Exception {
		
		int pageUnit   = dft.getPageUnit();
		
		// 총 데이터 개수
		int total      = nboardService.selectNboardTotal(dft);
		// 연산처리를 위해 dto에 값을 보냄
		dft.setTotal(total);
		
		// (double)15/10 -> Math.ceil(1.5) -> (int)2.0 -> 2 페이지 출력배열
		// 총페이지 개수를 계산 시키는 장면
		dft.setTotalpage();
		// 계산 후 결과를 얻어옴
		int totalPage  = dft.getTotalpage();
		
		// 출력페이지번호
		int pageIndex  = dft.getPageIndex();
		
		// 출력페이지의 시작 행번호
		dft.setPageRownum();
		int pageRownum = dft.getPageRownum();
		
		// SQL에 적용할 시작번호
		dft.setFirstIndex();
		int firstIndex = dft.getFirstIndex();
		
		// SQL에 적용할 종료번호
		dft.setLastIndex();
		int lastIndex  = dft.getLastIndex();
		
		List<?> list1  = nboardService.selectNboardEmsisList(dft); // 강조데이터
		List<?> list2  = nboardService.selectNboardList(dft); // 본데이터
		
		model.addAttribute("emsisList", list1);
		model.addAttribute("resultList",list2);
		model.addAttribute("total",total);
		model.addAttribute("pageRownum",pageRownum);
		model.addAttribute("totalPage",totalPage);
		
		return "board/nboardList";
	}
	
	@GetMapping("nboardDetail/{seqid}")
	public String selectNboardDetail(@PathVariable int seqid,ModelMap model) throws Exception {
		
		nboardService.updateNboardHits(seqid);
		NboardDto dto = nboardService.selectNboardDetail(seqid);
		model.addAttribute("dto",dto);
		return "board/nboardDetail";
	}
}