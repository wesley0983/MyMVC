package com.product.model;

public class ProMain {
	
	public static void main (String[]  args) {
		
		ProJDBCDAO proDAO = new ProJDBCDAO();
		//新增
		ProVO pro1 = new ProVO();
        pro1.setPro_classid("PT001");
        pro1.setPro_name("Addies");
        pro1.setPro_pic(null);
        pro1.setPro_pic_ext("PIC_EXT");
        pro1.setPro_format("9.5");
        pro1.setPro_bonus(2000);
        pro1.setPro_stock(20);
        pro1.setPro_safestock(5);
    	pro1.setPro_details("DETAILS");
    	pro1.setPro_shelve("ON");
    	pro1.setPro_all_assess(5);
    	pro1.setPro_all_assessman(10);
        proDAO.insert(pro1);
        System.out.println("成功INSERT");
        
        //修改
        ProVO pro2 = new ProVO();
        
        pro2.setPro_classid("PT001");
        pro2.setPro_name("Addies");
        pro2.setPro_pic(null);
        pro2.setPro_pic_ext("TEST");
        pro2.setPro_format("TEST");
        pro2.setPro_bonus(3000);
        pro2.setPro_stock(50);
        pro2.setPro_safestock(10);
    	pro2.setPro_details("test...................");
    	pro2.setPro_shelve("上架中");
    	pro2.setPro_all_assess(6);
    	pro2.setPro_all_assessman(100);
    	pro2.setPro_no("PR001");
    	proDAO.update(pro2);
    	System.out.println("成功修改");
        
		
	}

}
