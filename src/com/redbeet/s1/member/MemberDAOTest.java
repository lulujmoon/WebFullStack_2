package com.redbeet.s1.member;

public class MemberDAOTest {

	public static void main(String[] args) {
		MemberDAO mDAO = new MemberDAO();
		MemberDTO mDTO = new MemberDTO();
		mDTO.setId("jmun74");
		mDTO.setPw("mun6801");
		mDTO.setPhone("01054016801");
		mDTO.setEmail("kaya2983@gmail.com");
		mDTO.setName("정현문");
		
		try {
			int result = mDAO.join(mDTO);
			if(result==1) {
				System.out.println("회원가입 성공");
			}else{
				System.out.println("회원가입 실패");
			}
			
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
