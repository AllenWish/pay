package cn.cgy.controller;

import cn.cgy.pojo.AwPay;
import cn.cgy.service.PayService;
import cn.cgy.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/22 0022.
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;
    @RequestMapping("/getData")
    @ResponseBody
    public Map<String,Object> getData(String className,String parName){

        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("className",className);
        paramsMap.put("parName",parName);
        List<Map<String,Object>> awPays = payService.getData(paramsMap);
        return ResultMap.successMap(awPays);
    }
}
