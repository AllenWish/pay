package cn.cgy.service;


import cn.cgy.pojo.AwClass;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-11-21.
 */
public interface AwTypeService {

    int deleteByPrimaryKey(Integer id);

    int insert(AwClass record);

    AwClass selectByPrimaryKey(Integer id);

    List<AwClass> selectAll();

    int updateByPrimaryKey(AwClass record);

    List<Map<String,Object>> getAwClass(Map<String,Object> map);
}
