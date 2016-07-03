package cn.cgy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cgy.utils.PagesUtils;
@Controller
@RequestMapping("/")
public class IndexController {

	
	@RequestMapping("/"+PagesUtils.TO_INDEX)
	public String toIndex(Model model) throws Exception{
		//跳转到首页
		return PagesUtils.TO_INDEX;
	}
	
	@RequestMapping("/"+PagesUtils.MY_PAGE)
	public String mypage(Model model) throws Exception{
		//跳转到首页
		return PagesUtils.MY_PAGE;
	}
	
	@RequestMapping("/"+PagesUtils.COMPLATE)
	public String complate(Model model) throws Exception{
		//跳转到对比页
		return PagesUtils.COMPLATE;
	}
	
	
	@RequestMapping("/"+PagesUtils.MANAGE)
	public String manage(Model model) throws Exception{
		//跳转到对比页
		return PagesUtils.MANAGE;
	}
	
	@RequestMapping("/"+PagesUtils.ABOUT)
	public String about() throws Exception{
		
		return PagesUtils.ABOUT;
	}
	
}
