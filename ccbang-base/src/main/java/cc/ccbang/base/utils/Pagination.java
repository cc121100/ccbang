package cc.ccbang.base.utils;

import java.util.HashMap;
import java.util.Map;

public class Pagination {
	
	public final static int START_0 = 0;
	public final static int LENGTH_0 = 0;
	public final static Pagination DEFAULT = new Pagination();
	
	public final static String PAGINATION_PARAM_KEY = "p";
	
	private int start;
	
	private int length;
	
	
	public Pagination() {
		this.start = START_0;
	    this.length = LENGTH_0;
	}

	public Pagination(int start, int length) {
		this.start = start;
		this.length = length;
	}
	
	public Pagination(int start, int length, Map<String, Object> whereClause) {
		super();
		this.start = start;
		this.length = length;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
