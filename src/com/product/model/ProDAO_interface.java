package com.product.model;

import java.util.List;

public interface ProDAO_interface {
	    public abstract void insert (ProVO proVO);
	    public abstract void update (ProVO proVO);
	    public abstract void delete (String pro_no);
	    
	    public List<ProVO> getAll();

}
