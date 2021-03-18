package com.redbeet.s1.passbook;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.redbeet.s1.util.ActionForward;

public class PassbookService {
	
	private PassbookDAO passbookDAO;
	
	//getList
	//DAO의 getList 호출 후 리턴
	public void setPassbookDAO(PassbookDAO passbookDAO) {
		this.passbookDAO = passbookDAO;
		
	}
	
	public ActionForward getList(HttpServletRequest request) throws Exception {
		ActionForward actionForward = new ActionForward();
		List<PassbookDTO> passbooks = passbookDAO.getList();
		request.setAttribute("list", passbooks);
		actionForward.setPath("../WEB-INF/passbook/passbookList.jsp");
		actionForward.setCheck(true);
		return actionForward;
	}
	
	public ActionForward search(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("../WEB-INF/passbook/passbookSearch.jsp");
		actionForward.setCheck(true);
		return actionForward;
	}
	
	
	
	public ActionForward getSelect(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		PassbookDTO passbookDTO = new PassbookDTO();
		passbookDTO.setNum(Long.parseLong(request.getParameter("num")));
		passbookDTO = passbookDAO.getSelect(passbookDTO);
		if(passbookDTO!=null) {
		request.setAttribute("passbook", passbookDTO);
		actionForward.setPath("../WEB-INF/passbook/passbookSelect.jsp");
		actionForward.setCheck(true);
		}else {
			System.out.println("일치하는 번호 없음");
		}
		return actionForward;
	}
	
	public ActionForward setWrite(HttpServletRequest request) throws Exception {
		ActionForward actionForward = new ActionForward();
		String method = request.getMethod();
		actionForward.setPath("../WEB-INF/passbook/passbookWrite.jsp");
		actionForward.setCheck(true);
		
		if(method.toUpperCase().equals("POST")) {
			PassbookDTO passbookDTO = new PassbookDTO();
			passbookDTO.setName(request.getParameter("name"));
			passbookDTO.setIrate(Double.parseDouble(request.getParameter("irate")));
			passbookDTO.setSell(request.getParameter("sell"));
			int result = passbookDAO.setWrite(passbookDTO);
			if(result==1) {
				actionForward.setPath("./passbookList.do");
			}else {
				System.out.println("입력 실패");
			}
		}
		
		return actionForward;
		
		
	}
}
