package cc.ccbang.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ccbang.base.dao.JokeDAO;
import cc.ccbang.base.model.Joke;
import cc.ccbang.base.service.JokeService;
import cc.ccbang.base.utils.PageResult;
import cc.ccbang.base.utils.Pagination;
import cc.ccbang.base.utils.QueryParam;
import cc.ccbang.base.utils.UUIDUtil;

@Service
public class JokeServiceImpl implements JokeService{
	
	@Autowired
	private JokeDAO jokeDAO;

	@Override
	public List<Joke> getJokeList() {
		return jokeDAO.getAll();
	}

	@Override
	public PageResult<Joke> queryByPage(Pagination page, QueryParam q) {
		PageResult<Joke> pageResult = new PageResult<>();
		
		pageResult.setTotalCount(jokeDAO.countByPage(q));
		pageResult.setList(jokeDAO.queryByPage(page, q));
		return pageResult;
	}

	@Override
	@Transactional
	public int addJoke(Joke joke) {
		
		joke.setId(UUIDUtil.uuid());
		joke.setVersion(1);
		joke.setCreatedDt(new Date());
		joke.setCreatedBy("Test");
		return jokeDAO.insert(joke);
	}

}
