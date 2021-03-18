package com.redbeet.s1.passbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redbeet.s1.util.ActionForward;

/**
 * Servlet implementation class PassbookController
 */
@WebServlet("/PassbookController")
public class PassbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PassbookService passbookService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PassbookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		passbookService = new PassbookService();
		PassbookDAO passbookDAO = new PassbookDAO();
		passbookService.setPassbookDAO(passbookDAO);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모든 컨트롤러에 한글 Encoding 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//MemberController 참조
		//1. uri 따기
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf('/'));
		ActionForward actionForward = null;
		try {
			if(uri.equals("/passbookList.do")){
				System.out.println("PassBookList 실행");
				actionForward = passbookService.getList(request);
			}else if(uri.equals("/passbookSelect.do")){
				System.out.println("passbookSelect 실행");
				actionForward = passbookService.getSelect(request);
			}else if(uri.equals("/passbookWrite.do")) {
				System.out.println("passbookWrite 실행");
				actionForward = passbookService.setWrite(request);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(actionForward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionForward.getPath());
		}
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
