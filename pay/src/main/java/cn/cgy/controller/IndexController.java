package cn.cgy.controller;

import cn.cgy.pojo.AwUser;
import cn.cgy.service.AwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cgy.utils.PagesUtils;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private AwUserService awUserService;
	
	@RequestMapping("/"+PagesUtils.TO_INDEX)
	public String toIndex(Model model) throws Exception{
		//跳转到首页
		return PagesUtils.TO_INDEX;
	}

    @RequestMapping("/showOutpay")
    public String showOutpay() throws Exception{
	    return "showOutpay";
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
	
	
	@RequestMapping("/manageClass")
	public String manageClass(Model model) throws Exception{
		//跳转到对比页
		return "manageClass";
	}
	@RequestMapping("/managePer")
	public String managePer(Model model) throws Exception{
        //跳转到对比页
		return "managePer";
	}
	
	@RequestMapping("/"+PagesUtils.ABOUT)
	public String about() throws Exception{
		
		return PagesUtils.ABOUT;
	}
	
}
