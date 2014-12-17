package cc.ccbang.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface BaseDAO<T> {
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public T getById(String id);
	
	
}
