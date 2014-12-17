package cc.ccbang.server.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cc.ccbang.base.model.Joke;
import cc.ccbang.base.service.JokeService;
import cc.ccbang.base.utils.PageResult;
import cc.ccbang.base.utils.Pagination;
import cc.ccbang.base.utils.QueryParam;
import cc.ccbang.jqdatatable.JqPageRequest;
import cc.ccbang.jqdatatable.JqPageResponse;
import cc.ccbang.server.JsonResponse;
import cc.ccbang.server.PagenationResponse;


@Controller
public class JokeController {
	
	@Autowired
	JokeService jokeService;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
//	@ModelAttribute
//	public void voidsetReqAndResp(HttpServletRequest request, HttpServletResponse response){
//		this.request = request;
//		this.response = response;
//	}
	
	@RequestMapping(value="/jokes", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public JqPageResponse<Joke> getAll(){//@RequestParam int start,@RequestParam int length, @RequestParam int draw,
		
		request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		JqPageRequest jqReq = new JqPageRequest(request);
		
		System.err.println("start:" + jqReq.getStart());
		System.err.println("length:" + jqReq.getLength());
		System.err.println("draw:" + jqReq.getDraw());
		
		PageResult<Joke> pageResult = jokeService.queryByPage(new Pagination(jqReq.getStart(), jqReq.getLength()),jqReq);
		
		JqPageResponse<Joke> response = new JqPageResponse<>();
		response.setDraw(jqReq.getDraw());
		response.setRecordsTotal(pageResult.getTotalCount());
		response.setRecordsFiltered(pageResult.getTotalCount());
		
		response.setData(pageResult.getList());
		
		System.err.println("json:" + pageResult.getList().toString());
		return response;
	}
	
	@RequestMapping(value="/joke", method = RequestMethod.PUT,produces = "application/json")
	@ResponseBody
	public JqPageResponse<Joke> add(@RequestBody MultiValueMap<String,String> map1){
		request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//System.out.println(joke);
		//return jokeService.addJoke(joke);
		
		for(Entry entry : map1.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
		PageResult<Joke> pageResult = jokeService.queryByPage(new Pagination(),new QueryParam());
		
		JqPageResponse<Joke> response = new JqPageResponse<>();
		response.setDraw(1);
		response.setRecordsTotal(pageResult.getTotalCount());
		response.setRecordsFiltered(pageResult.getTotalCount());
		
		response.setData(pageResult.getList());
		
		return response;
	}
	
	@RequestMapping(value="/joke", method = RequestMethod.DELETE,produces = "application/json")
	@ResponseBody
	public int delete(@RequestParam String id){
		System.out.println(id);
		return 0;
	}
	

	
}
