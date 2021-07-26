package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;




@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	//전체리스트 가져오기
	public List<PersonVo> getPersonList(){
		
		
		//db요청
		//리스트 가져온다
		List<PersonVo> personList =  sqlSession.selectList("phonebook.selectList");
		System.out.println("dao");
		System.out.println(personList);
		
		return personList;
	}
		
	//전화번호 저장
	public int personInsert(PersonVo personVo) {
		int count = sqlSession.insert("phonebook.personInsert",personVo);
		
		
		return count;
	}
	
	//전화번호 저장 2 
	
	public int personInsert2(String name,String hp,String company) {
		System.out.println("phoneDao.personInsert2(");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		//PersonVo personVo = new PersonVo();
		
		//map을 사용해서 데이터를 묶는다.
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		
		int count = sqlSession.insert("phonebook.personInsert2", personMap);
		
		
		System.out.println("dao.personInsert2결과:"+ count);
		return count;
	}
		
	//전화번호 삭제
	public int personDelete(int personId) {
		System.out.println("폰다오 딜리트");
		
		 int count = sqlSession.delete("phonebook.personDelete",personId);
		
		return count;
	}
	
	
	//수정폼
	public PersonVo getPerson(int personId) {
		PersonVo personVo = sqlSession.selectOne("phonebook.selectPerson",personId);
		
		return personVo;
	}
	
	//수정폼 2 
	public Map<String, Object> getPerson2(int personId) {
		System.out.println("phoneDao.getPserson2()");
		System.out.println(personId);
		
		Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectPerson2",personId);
		
		System.out.println(personMap);
		
		return personMap;
	}
	
	
	//수정2
	public int personUpdate2(int personId,String name,String hp,String company){
		
		
		System.out.println("phoneDao.personUpdate2()");
		
		System.out.println(personId);
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		personMap.put("personId",personId);
		
		
		int count = sqlSession.update("phonebook.updatePerson2", personMap);
		
		return count;
		
		
		
	}
	
	
	
}