package com.myhome.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.myhome.dto.DataDto;
import com.myhome.dto.DefaultDto;
import com.myhome.service.DataService;

@Controller
public class DataController {
	
	@Autowired
	DataService dataService;
	
	//클래스변수(전역)변수
	public static String path = "C:/eclipse-workspace7/myhome/src/main/webapp/data";
	
	//1745980014969-1.txt/1745980014971-2.txt/
	public String filesNewMake(String files) {
		
		if(!files.equals("")) {
			String[] str = files.split("／");
			for(int i=0; i<str.length; i++) {
				String fname      = str[i];
				String filepath   = path+"/"+fname;
				File   file 	  = new File(filepath);
				if(file.exists() == false) files = files.replace(fname + "/", "");
			}
		}
		return files;
	}
	
	@PostMapping("dataFileDelete")
	@ResponseBody
	public String dataFileDelete(DataDto dto,String delname) throws Exception {
		
		String message = "ok";
		String 		f1 = path + "/" + delname;
		File file = new File(f1);
		if(file.exists() == true) file.delete();
		
		int result = dataService.updateDataFileName(dto);
		if( result == 0) message = "fail";
		
		return message;
	}
	
	@PostMapping
	@ResponseBody
	public String deleteData(DataDto dto) throws Exception {
		
		String  message ="1";
		String filename = dto.getFilename();
		
		// 파일삭제
		filename = filename.trim();
		if(filename != null && !filename.equals("")) {
			String[] files = filename.split("／");
			for(int i=0; i<files.length; i++) {
				String filepath = path + "/" + files[i];
				File file = new File(filepath);
				file.delete();
			}
		}
		
		// 삭제서비스 실행
		int result = dataService.deleteData(dto);
		if (result == 0) message = "4";
		
		return message;
	}
	
	@GetMapping("dataPassWrite/{seqid},{filename}")
	public String dataPassWrite(@PathVariable int seqid,@PathVariable String filename,ModelMap model) 
	throws Exception {
		
		model.addAttribute("seqid",seqid);
		model.addAttribute("filename",filename);
		
		return "board/dataPassWrite";
	}
	
	@GetMapping("dataWrite")
	public String dataWrite() {return "board/dataWrite";}
	
	@PostMapping("dataInsert")
	@ResponseBody
	public String insertData(MultipartHttpServletRequest request,DataDto dto) throws Exception {
		
		String   message = "ok";
		String filenames =   "";
		int 		 cnt =    0;
		
		//넘어온 파일(들)을 가져옴
		Map map = request.getFileMap();
		
		// Map의 키값(들)을 가져옴
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) { //파일의 존재유무
			
			// 키값이 있는 위치로 커서를 내려보냄
			Entry entry = (Entry) it.next();
			
			// 해당위치에서 실제파일의 정보들을 가져온다.
			MultipartFile file = (MultipartFile)entry.getValue();
			
			if(file.getSize() > 0) {
				
				String filename = System.currentTimeMillis() + "-" + cnt;
				
				// abc.jpg -> f2[0] = "abc"; f2[1] = "jpg";
				String   f1 = file.getOriginalFilename();
				String[] f2 = f1.split("\\.");
				String  exe = f2[f2.length-1];
				filename   += "."+exe;
				
				//String filename = file.getOriginalFilename();
				String filepath = path+"/"+filename;
			
				//실제 저장 / 파일 카피
				file.transferTo(new File(filepath));
				filenames += filename + "／";
				//dto.setFilepath(dirname);
				//dto.setFilename(filename);
				//dto.setFilesize(Integer.parseInt(file.getSize()+""));
			}
			cnt++;
		}
		dto.setFilepath("/webapp/data");
		dto.setFilename(filenames);
		int result = dataService.insertData(dto);
		if (result == 0) message ="fail";
		
		return message;
	}
	
	@PostMapping("dataUpdate")
	@ResponseBody
	public String updateData(MultipartHttpServletRequest request,DataDto dto) throws Exception {
		
		String   message = "ok";
		String filenames =   "";
		int 		 cnt =    0;
		
		// 업로드된 파일이름(들)을 가져옴
		// aa1.txt/bb1.txt
		String filename  = dto.getFilename();
		
		// 최종변경 파일명이 들어갈 변수로 사용됨
		String[] str1	 = new String[3]; // str1[0] = null, str1[1] = null, str1[2] = null;
		
		// 기본 파일명(들)을 배열처리함 
		String[] str2    = filename.split("／");
		
		// str2 -> str1 으로 값을 넘김
		for(int i=0; i<str2.length; i++) str1[i] = str2[i];
		//str1[0] = "aa1.txt";
		//str1[1] = "bb1.txt";
		//str1[2] =  null;
		
		//넘어온 파일(들)을 가져옴 (물리적 파일의 정보가 들어옴)
		Map map = request.getFileMap();
		
		// Map의 키값(들)을 가져옴
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {	
			
				// 키값이 있는 위치로 커서를 내려보냄
				Entry entry = (Entry) it.next();
				
				// 해당위치에서 실제파일의 정보들을 가져온다.
				MultipartFile file = (MultipartFile)entry.getValue();
				
				// abc.jpg -> array[2-1]
				String orgname = file.getOriginalFilename();
				
				if(orgname != null && !orgname.equals("")) {
					String[]     array = orgname.split("\\.");
					String		   exe = array[array.length-1]; // 확장자(예:txt 또는 jpg,png)
					String        unix = System.currentTimeMillis() + "-" + cnt;
					String     newname = unix + "." + exe;
					
					// input file 상자이음 :: 예) myfiel1 또는 myfile2
					String 	   boxname = file.getName();
					String 	 boxnumber = boxname.replace("myfile","");
					int			number = Integer.parseInt(boxnumber);
					String     delname = str1[number];
					
					if(delname != null && !delname.equals("")) {
						File dfile = new File(path + "/" + delname);
						if(dfile.exists() == true) dfile.delete();
					}
					
					str1[number] = newname;
					
					file.transferTo(new File(path + "/" + newname));
					cnt++;
				}
		}
	
		for(int i=0; i<str1.length; i++) filenames += str1[i] + "／";
		
		dto.setFilename(filenames);
		int result = dataService.updateData(dto);
		if (result == 0) message ="fail";
		
		return message;
	}
	
	@GetMapping("dataList")
	public String selectDataList(DefaultDto dft,ModelMap model) throws Exception {
		
		int total = dataService.selectDataTotal(dft);
		// 연산처리를 위해 dto에 값을 세팅(보냄)
		dft.setTotal(total);

		// 총 페이지 개수를 계산 시키는 장면
		dft.setTotalpage();
		// 계산 후 결과를 얻어옴
		int totalPage  = dft.getTotalpage();

		// 출력 페이지의 시작 번호를 계산 시키는 장면
		dft.setPageRownum();
		// 계산 후 결과를 얻어옴
		int pageRownum = dft.getPageRownum();

		// SQL에 적용할 시작번호
		// 시작 번호의 계산 후 관련 변수에 값을 넣어 줌
		dft.setFirstIndex();
		
		// SQL에 적용할 종료번호
		// 끝 번호의 계산 후 관련 변수에 값을 넣어 줌
		dft.setLastIndex();
		
		//  서비스 목록출력
		List<?>   list1 = dataService.selectDataList(dft);
		List<Map> list2 = new ArrayList<Map>();
		
		for(int i=0; i<list1.size(); i++) {
			Map map = (Map)list1.get(i);
			String files = (String)map.get("FILENAME");
			if( files != null) {
				files  = filesNewMake(files);
				map.put("FILENAME",files);
			}
			list2.add(map);
		}
		
		model.addAttribute("resultList", list2);
		model.addAttribute("total", total);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageRownum", pageRownum);
		
		return "board/dataList";
	}
	
	@GetMapping("dataDetail/{seqid}")
	public String selectDataDetail(@PathVariable int seqid,ModelMap model) throws Exception {
		
		dataService.updateDataHits(seqid);
		
		DataDto dto = dataService.selectDataDetail(seqid);
		String files = dto.getFilename().trim();
			   files = filesNewMake(files);
		
		dto.setFilename(files);
		model.addAttribute("dto",dto);
		
		return "board/dataDetail";
	}
	
	@GetMapping("dataModify/{seqid}")
	public String selectDataModify(@PathVariable int seqid,ModelMap model) throws Exception {
		
		DataDto dto = dataService.selectDataDetail(seqid);
		String files = dto.getFilename().trim();
			   files = filesNewMake(files);
		
		dto.setFilename(files);
		model.addAttribute("dto",dto);
		
		return "board/dataModify";
	}
}