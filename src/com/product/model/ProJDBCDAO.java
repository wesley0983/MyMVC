package com.product.model;

import java.sql.*;
import java.util.List;

public class ProJDBCDAO implements ProDAO_interface{
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "test";
	private static final String PASSWORD = "123456";
	private static final String INSERT_INTO_DATA = "Insert into PRODUCT (PRO_NO,PRO_CLASSID,PRO_NAME,PRO_PIC,PRO_PIC_EXT,PRO_FORMAT,PRO_BONUS,PRO_STOCK,PRO_SAFESTOCK,PRO_DETAILS,PRO_SHELVE,PRO_ALL_ASSESS,PRO_ALL_ASSESSMAN) values ('PR'||LPAD(to_char(PRODUCT_SEQ.NEXTVAL), 3, '0'),?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String INSERT_UPDATE = "UPDATE PRODUCT SET  PRO_CLASSID = ?, PRO_NAME = ?, PRO_PIC = ?, PRO_PIC_EXT = ?, PRO_FORMAT = ?, PRO_BONUS = ?, PRO_STOCK = ?, PRO_SAFESTOCK = ?, PRO_DETAILS = ?, PRO_SHELVE = ?, PRO_ALL_ASSESS = ?, PRO_ALL_ASSESSMAN = ? where PRO_NO = ?";
	
	Connection con = null;
	PreparedStatement ps = null;
	
	
	@Override
	public void insert(ProVO proVO) {
		 try {
			    Class.forName(DRIVER);

				con = DriverManager.getConnection(URL, USER, PASSWORD);
				
		        ps = con.prepareStatement(INSERT_INTO_DATA);
		        ps.setString(1,proVO.getPro_classid());
		        ps.setString(2, proVO.getPro_name());
		        ps.setBytes(3, proVO.getPro_pic());
		        ps.setString(4, proVO.getPro_pic_ext());
		        ps.setString(5, proVO.getPro_format());
		        ps.setInt(6, proVO.getPro_bonus());
                ps.setInt(7, proVO.getPro_stock());
		        ps.setInt (8,proVO.getPro_safestock());
		    	ps.setString (9,proVO.getPro_details());
		    	ps.setString (10,proVO.getPro_shelve());
		    	ps.setInt (11,proVO.getPro_all_assess());
		    	ps.setInt (12,proVO.getPro_all_assessman());
		        
		        ps.executeQuery();
		        
		    } catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getMessage());
				
			} finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		
		
	}

	@Override
	public void update(ProVO proVO) {
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		    ps = con.prepareStatement(INSERT_UPDATE);
		    ps.setString(1,proVO.getPro_classid());
	        ps.setString(2, proVO.getPro_name());
	        ps.setBytes(3, proVO.getPro_pic());
	        ps.setString(4, proVO.getPro_pic_ext());
	        ps.setString(5, proVO.getPro_format());
	        ps.setInt(6, proVO.getPro_bonus());
            ps.setInt(7, proVO.getPro_stock());
	        ps.setInt (8,proVO.getPro_safestock());
	    	ps.setString (9,proVO.getPro_details());
	    	ps.setString (10,proVO.getPro_shelve());
	    	ps.setInt (11,proVO.getPro_all_assess());
	    	ps.setInt (12,proVO.getPro_all_assessman());
	    	ps.setString(13, proVO.getPro_no());
	    	
	    	ps.executeQuery();
		    
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
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
