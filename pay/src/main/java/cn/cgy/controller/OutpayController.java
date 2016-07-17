package cn.cgy.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cgy.pojo.Outpay;
import cn.cgy.service.OutpayService;
import cn.cgy.utils.PagesUtils;

@Controller
@RequestMapping("/")
public class OutpayController {

	@Autowired
	private OutpayService dao;
	
	
	@RequestMapping("/"+PagesUtils.SHOW_OUTPAY)
	public String showOutpay(Model model,HttpServletRequest request) throws Exception{
		
		String id = UUID.randomUUID().toString();
		
/*		HttpSession session =  request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//校验登录
		login(username,password);
		//成功后保存到session中
		session.setAttribute("loginUserName",username);
		*/
		List<Outpay> list = dao.queryOutpay();
		model.addAttribute("list", list);
		return PagesUtils.SHOW_OUTPAY;
	}
	
	private void login(String username, String password) {
		
	}
	
	@RequestMapping("/queryjl")
	public String queryjl(HttpServletRequest request,Model model,Outpay outpay) throws Exception{
		
		String createTime = outpay.getCreateTime();
		String user = outpay.getCreateUser();
		
		Outpay out = dao.queryOutpayById(1);
		List<Outpay> list = new ArrayList<Outpay>();
		list.add(out);
		
		model.addAttribute("list", list);
		return PagesUtils.SHOW_OUTPAY;
	}

	@RequestMapping("/"+PagesUtils.INSERT_OUTPAY)
	public String insert(Outpay outpay) throws Exception{
		dao.insert(outpay);
		return PagesUtils.redirect(PagesUtils.SHOW_OUTPAY);
	}
	
	@RequestMapping("/"+PagesUtils.UPDATE_OUTPAY)
	public String update(Outpay outpay) throws Exception{
		dao.update(outpay);
		return PagesUtils.redirect(PagesUtils.SHOW_OUTPAY);
	}
	
}
