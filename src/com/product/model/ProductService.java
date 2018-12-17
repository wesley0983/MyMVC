package com.product.model;

import java.util.List;

import com.productclass.model.ProductClassVO;

public class ProductService {
	
	private ProdouctDAO_interface prodouctDAO;

	public ProductService() {
		super();
		prodouctDAO = new ProdouctJDBCDAO();
		
	}
	
	public ProdouctVO addPro(String pro_classid ,String pro_name ,byte[]   pro_pic ,
			String pro_pic_ext ,String pro_format ,Integer pro_bonus ,
			Integer pro_stock ,Integer pro_safestock ,String pro_details ,
			String pro_shelve ,Integer pro_all_assess ,Integer pro_all_assessman) {
		
		ProdouctVO prodouctVO = new ProdouctVO();

		 prodouctVO.setPro_classid(pro_classid);
		 prodouctVO.setPro_name(pro_name);
		 prodouctVO.setPro_pic(pro_pic);
		 prodouctVO.setPro_pic_ext(pro_pic_ext);
		 prodouctVO.setPro_format(pro_format);
		 prodouctVO.setPro_bonus(pro_bonus);
		 prodouctVO.setPro_stock(pro_stock);
		 prodouctVO.setPro_safestock(pro_safestock);
		 prodouctVO.setPro_details(pro_details);
		 prodouctVO.setPro_shelve(pro_shelve);
		 prodouctVO.setPro_all_assess(pro_all_assess);
		 prodouctVO.setPro_all_assessman(pro_all_assessman);
		
		
		return prodouctVO;
	}
	
	public ProdouctVO getOneProduct (String pro_no) {
	    return prodouctDAO.findByPK(pro_no);	
	}
	
	public List<ProdouctVO> getAll(){
		return prodouctDAO.getAll();
	} 
	
}
