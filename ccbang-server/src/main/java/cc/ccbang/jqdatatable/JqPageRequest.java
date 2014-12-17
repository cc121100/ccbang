package cc.ccbang.jqdatatable;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import cc.ccbang.base.utils.QueryParam;

public class JqPageRequest extends QueryParam{
	
	private int start;
	
	private int length;
	
	private int draw;
	
	
	public JqPageRequest(HttpServletRequest request) {
		parseParam(request);
	}

	private void parseParam(HttpServletRequest request){
		String orderByColumnIndex = request.getParameter("order[0][column]");
		
		String column = "columns[" + orderByColumnIndex +"][data]";
		this.setOrderBy(request.getParameter(column));
		this.setOrderDir(request.getParameter("order[0][dir]"));
		
		this.start = Integer.parseInt(request.getParameter("start"));
		this.length = Integer.parseInt(request.getParameter("length"));
		this.draw = Integer.parseInt(request.getParameter("draw"));
		
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

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}
	
}
