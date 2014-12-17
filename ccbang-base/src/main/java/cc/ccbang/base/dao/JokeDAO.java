package cc.ccbang.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cc.ccbang.base.model.Joke;
import cc.ccbang.base.utils.Pagination;
import cc.ccbang.base.utils.QueryParam;

public interface JokeDAO extends BaseDAO<Joke> {
	
	List<Joke> getAll();
	
	List<Joke> queryByPage(@Param(value = Pagination.PAGINATION_PARAM_KEY) Pagination page,
						   @Param(value = "q") QueryParam param);
	
	int countByPage(@Param(value = "q") QueryParam param);
}
