package com.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller public class DeptController {
	
	@GetMapping("d/Write") public String deptWrite() {return "dept/deptWrite";}
}
