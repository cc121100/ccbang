package cc.ccbang.base.utils;

import java.util.List;

public class PageResult<T> {

	private int totalCount;
	
	private List<T> list;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
