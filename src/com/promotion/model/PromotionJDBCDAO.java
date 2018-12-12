package com.promotion.model;

import java.sql.*;
import java.util.List;

public class PromotionJDBCDAO implements PromotionDAO_interface{
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "test";
	private static final String PASSWORD = "123456";
	//新增
	private static final String INSERT = "Insert into PROMOTION (PROM_PROJECT_ID,PROM_PROJECT_NAME,PROM_PROJECT_SDATE,PROM_PROJECT_EDATE) values ('PR'||LPAD(to_char(PROMOTION_SEQ.NEXTVAL), 3, '0'),?,?,?)";
	//修改
	private static final String UPDATA = "update PROMOTION SET  PROM_PROJECT_NAME = ? , PROM_PROJECT_SDATE = ? ,  PROM_PROJECT_EDATE = ? WHERE PROM_PROJECT_ID = ?";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    //新增
	@Override
	public int insert(PromotionVO promotionVO) {
		int count = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		    ps = con.prepareStatement(INSERT);
		    
		    ps.setString(1, promotionVO.getProm_project_name());
		    ps.setDate(2, promotionVO.getProm_project_sdate());
		    ps.setDate(3, promotionVO.getProm_project_edate());
		    
		    count = ps.executeUpdate();
		    
		} catch (SQLException e) {		
			e.printStackTrace();
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
		
		return count;
	}

	@Override
	public int updata(PromotionVO promotionVO) {
		int count = 0 ;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(UPDATA);
			
			ps.setString(1, promotionVO.getProm_project_name());
			ps.setDate(2, promotionVO.getProm_project_sdate());
			ps.setDate(3, promotionVO.getProm_project_edate());
			ps.setString(4, promotionVO.getProm_project_id());
			
			count = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
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
		return count;
	}

	@Override
	public int detele(PromotionVO promotionVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PromotionVO findByPK(String prom_project_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PromotionVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
