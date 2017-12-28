package cn.cgy.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allenwish on 2017/12/25 0025.
 */
public class ResultMap {
    public static final Map<String,Object> retMap = new HashMap<>();

    public static Map<String,Object> successMap(Object data){
        retMap.put("flag",true);
        retMap.put("data",data);
        retMap.put("msg","加载成功");
        return retMap;
    }

    public static Map<String,Object> errorMap(String msg){
        retMap.put("flag",false);
        retMap.put("msg",msg);
        retMap.put("data",null);
        return retMap;
    }
}
