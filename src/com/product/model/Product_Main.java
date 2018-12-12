package com.product.model;

import java.util.List;

public class Product_Main {
	
	public static void main (String[]  args) {
		
		ProdouctJDBCDAO proDAO = new ProdouctJDBCDAO();
/*
		//新增
		ProdouctVO proVO1 = new ProdouctVO();
        proVO1.setPro_classid("PT001");
        proVO1.setPro_name("Addies");
        proVO1.setPro_pic(null);
        proVO1.setPro_pic_ext("PIC_EXT");
        proVO1.setPro_format("9.5");
        proVO1.setPro_bonus(2000);
        proVO1.setPro_stock(20);
        proVO1.setPro_safestock(5);
    	proVO1.setPro_details("DETAILS");
    	proVO1.setPro_shelve("ON");
    	proVO1.setPro_all_assess(5);
    	proVO1.setPro_all_assessman(10);
        proDAO.insert(proVO1);
        System.out.println("成功INSERT");
        
        //修改
        ProdouctVO proVO2 = new ProdouctVO();
        
        proVO2.setPro_classid("PT001");
        proVO2.setPro_name("Addies");
        proVO2.setPro_pic(null);
        proVO2.setPro_pic_ext("TEST");
        proVO2.setPro_format("TEST");
        proVO2.setPro_bonus(3000);
        proVO2.setPro_stock(50);
        proVO2.setPro_safestock(10);
    	proVO2.setPro_details("test...................");
    	proVO2.setPro_shelve("上架中");
    	proVO2.setPro_all_assess(6);
    	proVO2.setPro_all_assessman(100);
    	proVO2.setPro_no("PR001");
    	proDAO.update(proVO2);
    	System.out.println("成功修改");
 */       
		//單筆查詢
    	ProdouctVO proVO3 = proDAO.findByPK("P001");
    	System.out.println(proVO3.getPro_no() + ",");
    	System.out.println(proVO3.getPro_classid() + ",");
    	System.out.println(proVO3.getPro_name() + ",");
    	System.out.println(proVO3.getPro_pic() + ",");
    	System.out.println(proVO3.getPro_pic_ext() + ",");
    	System.out.println(proVO3.getPro_format() + ",");
    	System.out.println(proVO3.getPro_bonus() + ",");
    	System.out.println(proVO3.getPro_stock() + ",");
    	System.out.println(proVO3.getPro_safestock() + ",");
    	System.out.println(proVO3.getPro_details() + ",");
    	System.out.println(proVO3.getPro_shelve() + ",");
    	System.out.println(proVO3.getPro_all_assess() + ",");
    	System.out.println(proVO3.getPro_all_assessman() + ",");
    	System.out.println("-------------------------------------");
 
    	//多筆查詢
    	List<ProdouctVO> provolist = proDAO.getAll();
    	for (ProdouctVO proVO4 : provolist) {
        	System.out.println(proVO4.getPro_no() + ",");
        	System.out.println(proVO4.getPro_classid() + ",");
        	System.out.println(proVO4.getPro_name() + ",");
        	System.out.println(proVO4.getPro_pic() + ",");
        	System.out.println(proVO4.getPro_pic_ext() + ",");
        	System.out.println(proVO4.getPro_format() + ",");
        	System.out.println(proVO4.getPro_bonus() + ",");
        	System.out.println(proVO4.getPro_stock() + ",");
        	System.out.println(proVO4.getPro_safestock() + ",");
        	System.out.println(proVO4.getPro_details() + ",");
        	System.out.println(proVO4.getPro_shelve() + ",");
        	System.out.println(proVO4.getPro_all_assess() + ",");
        	System.out.println(proVO4.getPro_all_assessman() + ",");
        	System.out.println("-----------------------------------");
    	}
    	
    	//刪除  (雙子表格)   有問題需要改
//    	proDAO.delete("20181212-000001" , "PR001" ,"P001");
    	
    	
	}

}
