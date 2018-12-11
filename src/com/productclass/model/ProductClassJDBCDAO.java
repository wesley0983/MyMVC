package com.productclass.model;

import java.util.List;

public class ProductClassJDBCDAO implements ProductClassDAO_interface{
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin@localhost:1521:xe";
	private static final String USER = "test";
	private static final String PASSWORD = "123456";
	
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void insert(ProductClassVO proclassVO) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(ProductClassVO proclassVO) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ProductClassVO findByPK(String pro_classid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ProductClassVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
