package cn.cgy.service.impl;

import cn.cgy.dao.AwPayMapper;
import cn.cgy.pojo.AwPay;
import cn.cgy.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/22 0022.
 */
@Service("payService")
public class PayServiceIml implements PayService {
    @Resource
    private AwPayMapper payMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AwPay record) {
        return payMapper.insert(record);
    }

    @Override
    public AwPay selectByPrimaryKey(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AwPay> selectAll() {
        return payMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(AwPay record) {
        return payMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> getData(Map<String, Object> paramsMap) {
        return payMapper.getData(paramsMap);
    }
}
