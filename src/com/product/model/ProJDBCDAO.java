package com.product.model;

import java.sql.*;
import java.util.List;

public class ProJDBCDAO implements ProDAO_interface{
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "test";
	private static final String PASSWORD = "123456";
	private static final String INSERT_INTO_DATA = "Insert into PRODUCT (PRO_NO,PRO_CLASSID,PRO_NAME,PRO_PIC,PRO_PIC_EXT,PRO_FORMAT,PRO_BONUS,PRO_STOCK,PRO_SAFESTOCK,PRO_DETAILS,PRO_SHELVE,PRO_ALL_ASSESS,PRO_ALL_ASSESSMAN) values ('PR'||LPAD(to_char(PRODUCT_SEQ.NEXTVAL), 3, '0'),?,?,?,?,?,?,?,?,?,?,?,?)";
	

	@Override
	public void insert(ProVO proVO) {
		 try {
			    Class.forName(DRIVER);

				Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		        PreparedStatement ps = con.prepareStatement(INSERT_INTO_DATA);
		        ps.setString(1,proVO.getPro_classid());
		        ps.setString(2, proVO.getPro_name());
		        ps.setDate(3, proVO.getPro_pic());
		        
		        
		        
		    } catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

	@Override
	public void update(ProVO proVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String pro_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
