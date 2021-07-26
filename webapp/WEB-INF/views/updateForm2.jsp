<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import= "com.javaex.vo.PersonVo" %>
  <%@ page import = "com.javaex.dao.PhoneDao" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전화번호 수정폼</h1>
	<p>
		전화번호를 수정하고싶으니? <br>
		아래 항목을 기입하고 "수정" 버튼을 누르려무나
	</p>
	
	<form action="${pageContext.request.contextPath }/update2" method="get">
		이름(name): <input type="text" name="name" value="${requestScope.pMap.NAME }"> <br>
		핸드폰(hp): <input type="text" name="hp" value="${requestScope.pMap.HP }"> <br>
		회사(company): <input type="text" name="company" value="${requestScope.pMap.COMPANY }"> <br>
		<input type="text" name="personId" value="${pMap.PERSON_ID }">
	
		<button type="submit">수정</button>
	</form>
</body>
</html>