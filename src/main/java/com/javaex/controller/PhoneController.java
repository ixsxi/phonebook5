package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

		
	
		//필드
		//생성자	
		//메소드 gs
		//메소드 일반
	
	
	//리스트
	@RequestMapping(value="/list",method= {RequestMethod.GET,RequestMethod.POST} )
	public String list(Model model) {
		System.out.println("[phoneController.list]");
		
		//Dao 사용
		PhoneDao phoneDao = new PhoneDao();
		
		//Dao의 메소드 사용
		List<PersonVo> personList = phoneDao.getPersonList();
		
		System.out.println(personList);
		
		//model담기 (택배박스에 담기) -->ds전달된다 -->request의 attribute영엑에 넣는다.
		model.addAttribute("personList" ,personList);
		return "/WEB-INF/views/list.jsp";
	}
	
	//삭제
	@RequestMapping(value="delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@RequestParam("no")int id) {
		System.out.println("delete들어옴");
		
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personDelete(id);
		
		
		
		
		
		
		return "redirect:/list";
		
	}
	
	
	
	
	
	
	//수정폼
	
	@RequestMapping(value="/updateForm",method = {RequestMethod.GET,RequestMethod.POST})
	public String updateForm(Model model, @RequestParam("no") int id) {
		System.out.println("updateForm");
		
		PhoneDao phoneDao = new PhoneDao();
		PersonVo personVo = phoneDao.getPerson(id);
	
		
		model.addAttribute("personVo",personVo);
		
		return "/WEB-INF/views/updateForm.jsp";
		
	}
	
	
	//수정
	
	@RequestMapping(value="/update",method = {RequestMethod.GET,RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("update로들어옴");
		
		
		System.out.println(personVo);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		
		
		return "redirect:/list";
	
	}
	
	
	//쓰기폼
	
	@RequestMapping(value="/writeForm", method = {RequestMethod.GET,RequestMethod.POST})
	public String writeForm() {
		System.out.println("WriteForm");
		return  "/WEB-INF/views/writeForm.jsp";
	}
	
	
	
	//쓰기 (한방에 파라미터를 vo 로 담을때)
		@RequestMapping(value="/write", method = {RequestMethod.GET,RequestMethod.POST})
		public String write(@ModelAttribute PersonVo personVo) {
			
			System.out.println("[phoneController.wirte]");
			
			//@ModelAttribute --> new PersonVo()
						//   -->기본 생성자(디폴트 생성자) + setter  
			
			System.out.println(personVo);
			
			
			//Dao 의 personInser() 이용해서 데이터 저장
			PhoneDao phoneDao = new PhoneDao();
			phoneDao.personInsert(personVo);
			
			
			
			return "redirect:/list";
			
		}
		
	/* 파라미터 1개씩 받을때
	//쓰기
	@RequestMapping(value="/write", method = {RequestMethod.GET,RequestMethod.POST})
	public String write(@RequestParam("name") String name,
			@RequestParam("hp")String hp,@RequestParam("company") String company) {
		
		System.out.println("[phoneController.wirte]");
		
		
		PersonVo personVo = new PersonVo(name,hp,company);
		System.out.println(personVo);
		
		return "";
		
	}
	
	//쓰기
	//파라미터가 있을때도 있고 없을때도 있을떄
		@RequestMapping(value="/write", method = {RequestMethod.GET,RequestMethod.POST})
		public String write(@RequestParam("name") String name,
				@RequestParam("hp")String hp,
				@RequestParam(value="company",required=false,defaultValue="-1") String company) {
			
			System.out.println("[phoneController.wirte]");
			
			
			PersonVo personVo = new PersonVo(name,hp,company);
			System.out.println(personVo);
			
			return "";
	
		}
	*/   // pathvariable test
		@RequestMapping(value="/board/read/{no}",method= {RequestMethod.GET,RequestMethod.POST})
		public String read(@PathVariable("no")int boardNo) {
			
			System.out.println("pathVariable read");
			
			//**********ex*******************
			//localhost:8088/phonebook3/board/read/1
			//localhost:8088/phonebook3/board/read/2
			//localhost:8088/phonebook3/board/read/3
			
			System.out.println(boardNo);
			return "";
		}
		
	
		@RequestMapping(value="/test")
		public String test1() {
			System.out.println("test");
			
			return "/WEB-INF/views/test.jsp"; // 디스패치 서블릿 야 /WEB-INF/views/test.jsp 로 포워드해
		}
	
	
}
