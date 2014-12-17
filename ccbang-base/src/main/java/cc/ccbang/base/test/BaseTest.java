package cc.ccbang.base.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.ccbang.base.dao.JokeDAO;
import cc.ccbang.base.model.Joke;
import cc.ccbang.base.service.JokeService;
import cc.ccbang.base.utils.PageResult;
import cc.ccbang.base.utils.Pagination;
import cc.ccbang.base.utils.QueryParam;


public class BaseTest {
	
	private JokeDAO jokeDAO;
	private JokeService jokeService;

	@Before
    public void before(){                                                                   
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/applicationContext-base.xml"
                });
        jokeService = (JokeService) context.getBean("jokeServiceImpl");
        
        jokeDAO = (JokeDAO) context.getBean("jokeDAO");
    }
	
	
	@Test
	public void testJokeInsert(){
		Joke joke = new Joke();
		joke.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		joke.setContent("我有一只小毛驴，我从来也不骑！！！哈哈哈11");
		joke.setTime(new Date());
		System.out.println(joke.getContent());
		for(int i = 0; i < 10; i++){
			jokeDAO.insert(joke);
		}
	}
	
	@Test
	public void testJokeGet(){
		List<Joke> list = jokeService.getJokeList();
		for(Joke j : list){
			System.err.println(j.getId() + ", " + j.getTime() + ", " + j.getContent());
		}
	}
	
	@Test
	public void mytest(){
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
	}
	
	@Test
	public void testQueryPage(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "%我有%");
		map.put("orderBy", "content");
		//map.put("orderDir", "%我有%");
		
		QueryParam q = new QueryParam();
		q.setOrderBy("content");
		q.setOrderDir("desc");
		q.getWhere().put("content", "%我有%");
		
		List<Joke> list = jokeDAO.queryByPage(new Pagination(0, 10),q);
		for(Joke j : list){
			System.err.println(j.getId() + ", " + j.getTime() + ", " + j.getContent());
		}
		
//		System.err.println("========");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("content", "%我有%");
//		
//		List<Joke> list = jokeDAO.queryByPage(new Pagination(0, 100),map);
//		for(Joke j : list){
//			System.err.println(j.getId() + ", " + j.getTime() + ", " + j.getContent());
//		}
		
//		
//		PageResult<Joke> pageResult = jokeService.queryByPage(new Pagination(0, 10));
//		
//		for(Joke j : pageResult.getList()){
//			System.err.println(j.getId() + ", " + j.getTime() + ", " + j.getContent());
//		}
	}
}
