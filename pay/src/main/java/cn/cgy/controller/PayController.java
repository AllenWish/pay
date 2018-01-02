package cn.cgy.controller;

import cn.cgy.pojo.AwPay;
import cn.cgy.service.PayService;
import cn.cgy.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/gosave")
    public String gosave(Integer id, HttpServletRequest request){

        if(id!=null&&id>0){
            AwPay pay = payService.selectByPrimaryKey(id);
            request.setAttribute("pay",pay);
        }
        return "paysave";
    }

    @RequestMapping("/dosave")
    @ResponseBody
    public Map<String,Object> dosave(AwPay pay){
        try {
            if(pay.getId()==null||pay.getId()<=0){
                pay.setId(null);
                payService.insert(pay);
            }else{
                payService.updateByPrimaryKey(pay);
            }
        } catch (Exception e) {
            return ResultMap.errorMap(e.getMessage());
        }
        return ResultMap.successMap("/showOutpay");
    }

}
