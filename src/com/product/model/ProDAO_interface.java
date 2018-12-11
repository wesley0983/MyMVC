package com.product.model;

import java.util.List;

public interface ProDAO_interface {
	    void insert (ProVO proVO);
	    public abstract void update (ProVO proVO);
	    public abstract void delete (String ord_no ,String prom_project_id , String pro_no );
	    ProVO findByPK (String pro_no);
	    
	    public abstract List<ProVO> getAll();

}
