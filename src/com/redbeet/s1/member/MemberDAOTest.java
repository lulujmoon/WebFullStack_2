package com.redbeet.s1.member;

public class MemberDAOTest {

	public static void main(String[] args) {
		MemberDAO mDAO = new MemberDAO();
		MemberDTO mDTO = new MemberDTO();
		mDTO.setId("kaya2893");
		mDTO.setPw("mun6801");
		
		try {
			mDTO = mDAO.login(mDTO);
			if(mDTO!=null) {
			System.out.println(mDTO.getName());
			System.out.println(mDTO.getPhone());
			System.out.println(mDTO.getEmail());
			}else {
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
