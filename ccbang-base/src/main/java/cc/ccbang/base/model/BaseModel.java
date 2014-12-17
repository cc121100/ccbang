package cc.ccbang.base.model;

import java.util.Date;

public class BaseModel {
	
	private static final long serialVersionUID = -3152132842189516704L;

	protected Integer version;
	
	protected String createdBy;
	
	protected Date createdDt;
	
	protected String updatedBy;
	
	protected Date updatedDt;
	
	
	/*************get set*****************/
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDt() {
		return updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}


}
