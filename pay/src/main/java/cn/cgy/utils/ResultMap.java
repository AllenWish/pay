package cn.cgy.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allenwish on 2017/12/25 0025.
 */
public class ResultMap {
    private static final Map<String,Object> retMap = new HashMap<>();

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

    public static Map<String,Object> returnMap(Object data,boolean flag){
        retMap.clear();
        if(flag){
            return successMap(data);
        }else{
            return errorMap(data.toString());
        }
    }

    public static Map<String,Object> put(String key,Object value){
        retMap.put(key,value);
        return retMap;
    }
}
