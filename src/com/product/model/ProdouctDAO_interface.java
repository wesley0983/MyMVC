package com.product.model;

import java.util.List;

public interface ProdouctDAO_interface {
	//新增
	public abstract void insert (ProdouctVO proVO);
    //更新
	public abstract void update (ProdouctVO proVO);
    //刪除
	public abstract void delete (String ord_no ,String prom_project_id , String pro_no );
    //單筆查詢
	ProdouctVO findByPK (String pro_no);
	//全部查詢    
    public abstract List<ProdouctVO> getAll();

}
