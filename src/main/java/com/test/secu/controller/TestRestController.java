package com.test.secu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
	
	@GetMapping("/rest/test")
	@ResponseBody
	public String test() {
		return "index";
	}
	
	@GetMapping("/rest/list")
	public List<String> list(){
		List<String> list=new ArrayList<>();
		list.add("1");
		return list;
	}

}
