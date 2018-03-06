package com.swproject.swiis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication

public class SwiisApplication {
	@RequestMapping("/")
	@ResponseBody
	String hello()
	{
		return "SignUp.html";
	}
	public static void main(String[] args) {
		SpringApplication.run(SwiisApplication.class, args);
	}


}
