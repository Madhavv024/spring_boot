package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class hello_World {
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "Hello world";
	}
		
}
