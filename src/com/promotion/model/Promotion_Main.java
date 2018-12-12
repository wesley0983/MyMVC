package com.promotion.model;

public class Promotion_Main {
	
	public static void main (String[] args) {
		PromotionJDBCDAO promotionDAO = new PromotionJDBCDAO();
		
		//新增
		PromotionVO promotionVO = new PromotionVO();
		promotionVO.setProm_project_name("父親節");
		promotionVO.setProm_project_sdate(java.sql.Date.valueOf("2019-07-30"));
		promotionVO.setProm_project_edate(java.sql.Date.valueOf("2019-08-08"));
		System.out.println("新曾"+ promotionDAO.insert(promotionVO));
		
		//修改
		PromotionVO promotionVO1 = new PromotionVO();
		promotionVO1.setProm_project_id("PR001");
		promotionVO1.setProm_project_name("test");
		promotionVO1.setProm_project_sdate(java.sql.Date.valueOf("2019-01-01"));
		promotionVO1.setProm_project_edate(java.sql.Date.valueOf("2019-02-01"));
		System.out.println("修改"+promotionDAO.updata(promotionVO1));
		
	}
	
	

}
