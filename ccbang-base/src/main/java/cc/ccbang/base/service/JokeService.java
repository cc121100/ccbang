package cc.ccbang.base.service;

import java.util.List;

import cc.ccbang.base.model.Joke;
import cc.ccbang.base.utils.PageResult;
import cc.ccbang.base.utils.Pagination;
import cc.ccbang.base.utils.QueryParam;

public interface JokeService {

	List<Joke> getJokeList();
	
	PageResult<Joke> queryByPage(Pagination page,QueryParam q);
	
	int addJoke(Joke joke);
}
