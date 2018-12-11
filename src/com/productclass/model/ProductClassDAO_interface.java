package com.productclass.model;

import java.util.List;

public interface ProductClassDAO_interface {
	//新增
	public abstract void insert (ProductClassVO proclassVO );
	//修改
	public abstract void update (ProductClassVO proclassVO );
	//刪除
	public abstract void delete ();
	//查詢
	ProductClassVO findByPK (String pro_classid);
	//全部查詢
    public abstract List<ProductClassVO> getAll();
}
