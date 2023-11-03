package com.test.secu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController {
	
	@GetMapping("/test/test")
	public String test() {
		return "index";
	}
	
	@GetMapping("/test/list")
	@ResponseBody //json 형태의 데이터를 뽑기 위해 사용해야 하는 어노테이션
	public List<String> list(){
		List<String> list=new ArrayList<>();
		list.add("1");
		return list;
	}

}
