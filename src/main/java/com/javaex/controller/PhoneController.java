package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhoneController {

		
	
		//필드
		//생성자	
		//메소드 gs
		//메소드 일반
		@RequestMapping(value="/test")
		public String test1() {
			System.out.println("test");
			
			return "/WEB-INF/views/test.jsp"; // 디스패치 서블릿 야 /WEB-INF/views/test.jsp 로 포워드해
		}
	
	
}
