package cc.ccbang.base.utils;

import java.util.HashMap;
import java.util.Map;

public class QueryParam {
	
	private String orderBy;
	
	private String orderDir;
	
	private Map<String, Object> where;
	
	

	public QueryParam(String orderBy, String orderDir) {
		this.orderBy = orderBy;
		this.orderDir = orderDir;
		this.where = new HashMap<>();
	}

	public QueryParam() {
		this.where = new HashMap<String, Object>();
	}

	public QueryParam(String orderBy, String orderDir, Map<String, Object> where) {
		super();
		this.orderBy = orderBy;
		this.orderDir = orderDir;
		this.where = where;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderDir() {
		return orderDir;
	}

	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}

	public Map<String, Object> getWhere() {
		return where;
	}

	public void setWhere(Map<String, Object> where) {
		this.where = where;
	}
	
}
