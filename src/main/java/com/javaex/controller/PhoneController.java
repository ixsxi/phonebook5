package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

		
	
		//필드
		//@오토와이어드 자동연결 (dao)
		@Autowired
		private PhoneDao phoneDao;
		//생성자	
		//메소드 gs
		//메소드 일반
	
	
	//리스트
	@RequestMapping(value="/list",method= {RequestMethod.GET,RequestMethod.POST} )
	public String list(Model model) {
		System.out.println("[phoneController.list]");
		
		
		//Dao 사용
		//PhoneDao phoneDao = new PhoneDao();
		
		//Dao의 메소드 사용
		List<PersonVo> personList = phoneDao.getPersonList();
		
		
		
		//model담기 (택배박스에 담기) -->ds전달된다 -->request의 attribute영엑에 넣는다.
		model.addAttribute("personList" ,personList);
		
		//views
		return "/WEB-INF/views/list.jsp";
	}
	
	//삭제
	@RequestMapping(value="delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@RequestParam("no")int id) {
		System.out.println("delete들어옴");
		
		
		//PhoneDao phoneDao = new PhoneDao();
		phoneDao.personDelete(id);
		
		
		
		
		
		
		return "redirect:/list";
		
	}
	
	
	
	
	
	
	//수정폼, 
	
	@RequestMapping(value="/updateForm",method = {RequestMethod.GET,RequestMethod.POST})
	public String updateForm(Model model, @RequestParam("no") int personId) {
		System.out.println("updateForm");
		System.out.println(personId);
		
		
		PersonVo personVo = phoneDao.getPerson(personId);
	
		
		model.addAttribute("personVo",personVo);
		
		return "/WEB-INF/views/updateForm.jsp";
		
	}
	
	//수정폼 2 
	@RequestMapping(value="/updateForm2",method = {RequestMethod.GET,RequestMethod.POST})
	public String updateForm2(Model model,@RequestParam("no")int personId) {
		
		System.out.println("[phoneController.updateForm2]");
		System.out.println(personId);
		
		Map<String,Object> personMap = phoneDao.getPerson2(personId);
		
		System.out.println(personMap);
		
		model.addAttribute("pMap",personMap);
		return "/WEB-INF/views/updateForm2.jsp";
		
		
	}
	
	//수정
	
	@RequestMapping(value="/update",method = {RequestMethod.GET,RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("update로들어옴");
		
		
		System.out.println(personVo);
		
		//PhoneDao phoneDao = new PhoneDao();
		//phoneDao.personUpdate(personVo);
		
		
		return "redirect:/list";
	
	}
	
	//수정2
	@RequestMapping(value="/update2",method = {RequestMethod.GET,RequestMethod.POST})
	public String update2(@RequestParam("personId")int id,
						  @RequestParam("name") String name,
						  @RequestParam("hp") String hp,
						  @RequestParam("company")String company) {
		System.out.println("update2로들어옴");
		
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		//PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personUpdate2(id,name,hp,company);
		
		
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
			//PhoneDao phoneDao = new PhoneDao();
			phoneDao.personInsert(personVo);
			
			
			
			return "redirect:/list";
			
		}
		
		//쓰기2 파라미터로 받을때
		//파라미터로 받을때
		@RequestMapping(value="/write2", method= {RequestMethod.GET,RequestMethod.POST})
		public String write2(@RequestParam("name")String name,
							 @RequestParam("hp")String hp,
							 @RequestParam("company")String company) {
			
			System.out.println("pohoneController.write2");
			
			System.out.println(name);
			System.out.println(hp);
			System.out.println(company);
			
			int count = phoneDao.personInsert2(name,hp,company);
			
			return"redirect:/list";
			
		}
		
	
		@RequestMapping(value="/test")
		public String test1() {
			System.out.println("test");
			
			return "/WEB-INF/views/test.jsp"; // 디스패치 서블릿 야 /WEB-INF/views/test.jsp 로 포워드해
		}
	
	
}
