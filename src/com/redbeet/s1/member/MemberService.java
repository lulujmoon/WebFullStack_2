package com.redbeet.s1.member;

import javax.servlet.http.HttpServletRequest;

import com.redbeet.s1.util.ActionForward;

public class MemberService {

	private MemberDAO memberDAO;

	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public ActionForward memberLogin(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		actionForward.setPath("../WEB-INF/member/memberLogin.jsp");
		actionForward.setCheck(true);
		
		if(method.toUpperCase().equals("POST")) {
			MemberDTO mDTO = new MemberDTO();
			System.out.println("POST");
			mDTO.setId(request.getParameter("id"));
			mDTO.setPw(request.getParameter("pw"));
			mDTO = memberDAO.login(mDTO);
			if(mDTO!=null) {
				System.out.println(mDTO.getEmail());
				actionForward.setPath("../index.do");
				actionForward.setCheck(false);
			}else{
				System.out.println("NULL인데스");
				actionForward.setPath("./memberLogin.do");
				actionForward.setCheck(false);
			}	
		}
			
		return actionForward;
	}
	
	public ActionForward memberJoin(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		actionForward.setPath("../WEB-INF/member/memberJoin.jsp");
		actionForward.setCheck(true);
		System.out.println(actionForward.getPath());
		
		if(method.toUpperCase().equals("POST")) {
			System.out.println("POST");
			MemberDTO mDTO = new MemberDTO();
			mDTO.setId(request.getParameter("id"));
			mDTO.setPw(request.getParameter("pw"));
			mDTO.setName(request.getParameter("name"));
			mDTO.setPhone(request.getParameter("phone"));
			mDTO.setEmail(request.getParameter("email"));
			int result = memberDAO.join(mDTO);
			actionForward.setPath("../index.do");
			actionForward.setCheck(false);

		}
		
		return actionForward;
		
	}
}
