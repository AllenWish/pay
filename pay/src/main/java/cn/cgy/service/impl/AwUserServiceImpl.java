package cn.cgy.service.impl;

import cn.cgy.dao.AwUserMapper;
import cn.cgy.pojo.AwUser;
import cn.cgy.service.AwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017-11-21.
 */
@Service("awUserService")
@Transactional
public class AwUserServiceImpl implements AwUserService {

    @Autowired
    private AwUserMapper awUserMapper;

    @Override
    public List<AwUser> getAllUser() {
        return awUserMapper.selectAll();
    }

    @Override
    public List<AwUser> getUser(AwUser awUser) {
        return awUserMapper.getUser(awUser);
    }

    @Override
    public AwUser getUserById(int id) {
        return awUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(int id) throws Exception {
        int i = awUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public AwUser updateUser(AwUser awUser) {
        awUserMapper.updateByPrimaryKey(awUser);
        return this.getUserById(awUser.getId());
    }

    @Override
    public void insertUser(AwUser awUser) throws Exception {
        awUserMapper.insertUser(awUser);
    }
}
