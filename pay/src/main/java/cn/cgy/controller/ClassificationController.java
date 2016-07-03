package cn.cgy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cgy.service.ClassificationService;

@Controller
@RequestMapping("/")
public class ClassificationController {
	
	@Autowired
	private ClassificationService dao;
	
	
}
