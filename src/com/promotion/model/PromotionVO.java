package com.promotion.model;

import java.sql.Date;

public class PromotionVO {
	
	private String prom_project_id;
	private String prom_project_name;
	private Date prom_project_sdate;
	private Date prom_project_edate;
	
	
	public String getProm_project_id() {
		return prom_project_id;
	}
	public void setProm_project_id(String prom_project_id) {
		this.prom_project_id = prom_project_id;
	}
	public String getProm_project_name() {
		return prom_project_name;
	}
	public void setProm_project_name(String prom_project_name) {
		this.prom_project_name = prom_project_name;
	}
	public Date getProm_project_sdate() {
		return prom_project_sdate;
	}
	public void setProm_project_sdate(Date prom_project_sdate) {
		this.prom_project_sdate = prom_project_sdate;
	}
	public Date getProm_project_edate() {
		return prom_project_edate;
	}
	public void setProm_project_edate(Date prom_project_edate) {
		this.prom_project_edate = prom_project_edate;
	}
	
	

}
