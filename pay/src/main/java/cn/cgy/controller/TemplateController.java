package cn.cgy.controller;

import cn.cgy.template.TemplateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Allenwish on 2017-11-23.
 */
@Controller
@RequestMapping("/tempWish")
public class TemplateController {

    //localhost:8033/tempWish/allenTemp
    @RequestMapping("/allenTemp")
    public void allenTemp(HttpServletResponse response, HttpServletRequest request) throws Exception {
        TemplateUtil hf = new TemplateUtil(request);
        hf.process(request,response);
    }

}
