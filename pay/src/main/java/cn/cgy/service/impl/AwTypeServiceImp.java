package cn.cgy.service.impl;

import cn.cgy.dao.AwClassMapper;
import cn.cgy.pojo.AwClass;
import cn.cgy.service.AwTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by AllenWish on 2017-12-19.
 */
@Service("typeService")
public class AwTypeServiceImp implements AwTypeService {
    @Resource
    private AwClassMapper classMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AwClass record) {
        return classMapper.insert(record);
    }

    @Override
    public AwClass selectByPrimaryKey(Integer id) {
        return classMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AwClass> selectAll() {
        return classMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(AwClass record) {
        return classMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> getAwClass(Map<String, Object> map) {
        return classMapper.getAwClass(map);
    }
}
