package cc.ccbang.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String toIndex(){
		return "index";
	}
}
