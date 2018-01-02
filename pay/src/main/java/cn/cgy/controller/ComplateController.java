package cn.cgy.controller;

import cn.cgy.service.PayService;
import cn.cgy.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Administrator on 2018/1/2 0002.
 */
@Controller
@RequestMapping("/complate")
public class ComplateController {


    @Autowired
    private PayService payService;

    @RequestMapping("/getAll")
    @ResponseBody
    public Map<String,Object> getAll(){
        List<Map<String, Object>> withExt = null;
        try {
            withExt = payService.getWithExt();
            Set<Object> times = new HashSet<>();
            Set<Object> items = new HashSet<>();

            for (Map<String,Object> m:withExt) {
                times.add(m.get("createTime"));
                items.add(m.get("parentName"));
            }
            List<Map<String,Object>> dataMap = new ArrayList<>();
            Map<String,Object> tmap ;
            double[] data;
            Object[] objects = times.toArray();
            for(int i=0;i<items.size();i++){
                tmap = new HashMap<>();
                data = new double[items.size()];
                String parName = items.toArray()[i].toString();
                for(Map<String,Object> m:withExt){
                    if(m.get("parentName").equals(parName)){
                        for(int b=0;b<objects.length;b++){
                            if(m.get("createTime").equals(objects[b])){
                                data[b] = Double.valueOf(m.get("totAmount").toString());
                                break;
                            }
                        }
                    }

                }
                tmap.put("name",parName);
                tmap.put("data",data);
                dataMap.add(tmap);
            }
            ResultMap.put("xAxis",objects);
            return ResultMap.successMap(dataMap);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMap.returnMap(e.getMessage(),false);
        }
    }

}
