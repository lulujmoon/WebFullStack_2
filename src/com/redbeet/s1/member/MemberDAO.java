package com.redbeet.s1.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
	public Connection connect() throws Exception{
		String id="user01";
		String pw="user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver ="oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, id, pw);
		
		return con;
	}
	
	
	//memberJoin 데이터를 받아서 DB에 insert하는 메서드
	
	public int join(MemberDTO mDTO) throws Exception{
		Connection con = this.connect();
		String sql = "insert into members values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, mDTO.getId());
		ps.setString(2, mDTO.getPw());
		ps.setString(3, mDTO.getName());
		ps.setString(4, mDTO.getPhone());
		ps.setString(5, mDTO.getEmail());
		
		int result=0;
		result = ps.executeUpdate();
		
		ps.close();
		con.close();
		
		return result;
	}
	
	
	public MemberDTO login(MemberDTO mDTO) throws Exception {
		
		Connection con = this.connect();
		
		String sql = "select * from members where id=? and pw=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, mDTO.getId());
		ps.setString(2, mDTO.getPw());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			mDTO.setId(rs.getString("id"));
			mDTO.setPw(rs.getString("pw"));
			mDTO.setName(rs.getString("name"));
			mDTO.setPhone(rs.getString("phone"));
			mDTO.setEmail(rs.getString("email"));
		}else {
			mDTO = null;
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return mDTO;
		
	}

}
