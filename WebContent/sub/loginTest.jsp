<%@page import="com.redbeet.s1.member.MemberDTO"%>
<%@page import="com.redbeet.s1.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Test JSP Page</h1>
	
	<% 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	MemberDAO mDAO = new MemberDAO();
	MemberDTO mDTO = new MemberDTO();
	mDTO.setId(id);
	mDTO.setPw(pw);
	
	try{
	mDTO = mDAO.login(mDTO);
	}catch(Exception e){
	}
	
	String stc=null;
	if(mDTO.getEmail()!=null){
		stc = "로그인 성공";
	}else{
		stc = "로그인 실패";
	}
	%>
	
	<h2><%=stc %></h2>

</body>
</html>