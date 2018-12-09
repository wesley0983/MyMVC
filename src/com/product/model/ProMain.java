package com.product.model;

public class ProMain {
	
	public static void main (String[]  args) {
		
		ProJDBCDAO proDAO = new ProJDBCDAO();
		
		ProVO pro1 = new ProVO();
        pro1.setPro_classid("PT001");
        pro1.setPro_name("Nikex");
//        pro1.setPro_pic();
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
		
	}

}
