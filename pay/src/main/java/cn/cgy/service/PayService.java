package cn.cgy.service;

import cn.cgy.pojo.AwPay;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-11-21.
 */
public interface PayService {
    int deleteByPrimaryKey(Integer id);

    int insert(AwPay record);

    AwPay selectByPrimaryKey(Integer id);

    List<AwPay> selectAll();

    int updateByPrimaryKey(AwPay record);

    List<Map<String,Object>> getData(Map<String, Object> paramsMap);
}
