package com.redbeet.s1.passbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PassbookDAO {

	//getList
	//bankbook 테이블의 모든 row를 조회
	
	public Connection connect() throws Exception {
		String user = "user01";
		String pw = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,user,pw);
		
		return con;
	}
	
	public List<PassbookDTO> getList() throws Exception{
		Connection con = this.connect();
		String sql = "select * from passbook";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<PassbookDTO> passbooks = new ArrayList<>();
		while(rs.next()) {
			PassbookDTO pDTO = new PassbookDTO();
			pDTO.setName(rs.getString("name"));
			pDTO.setNum(rs.getLong("num"));
			pDTO.setIrate(rs.getDouble("irate"));
			pDTO.setSell(rs.getString("sell"));
			passbooks.add(pDTO);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return passbooks;
	}
	
	
	public PassbookDTO getSelect(PassbookDTO pDTO) throws Exception{
		Connection con = this.connect();
		String sql = "select * from passbook where num=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, pDTO.getNum());
		ResultSet rs = ps.executeQuery();
		PassbookDTO passbookDTO = new PassbookDTO();
		if(rs.next()) {
			passbookDTO.setName(rs.getString("name"));
			passbookDTO.setIrate(rs.getDouble("irate"));
			passbookDTO.setSell(rs.getString("sell"));
		}else {
			passbookDTO = null;
			System.out.println("일치하는 번호 없음");
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return passbookDTO;
		
	}
	
	public int setWrite(PassbookDTO passbookDTO) throws Exception {
		Connection con = this.connect();
		String sql = "insert into passbook (num, name, irate, sell) values (pass_seq.nextval,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, passbookDTO.getName());
		ps.setDouble(2, passbookDTO.getIrate());
		ps.setString(3, passbookDTO.getSell());
		
		int result = ps.executeUpdate();
		
		System.out.println("추가 완료");
		ps.close();
		con.close();
		
		return result;
	}
	
}
