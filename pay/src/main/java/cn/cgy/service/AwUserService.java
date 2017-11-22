package cn.cgy.service;


import cn.cgy.pojo.AwUser;

import java.util.List;

/**
 * Created by Administrator on 2017-11-21.
 */
public interface AwUserService {

    public List<AwUser> getAllUser();

    public AwUser getUser(AwUser awUser);

    public AwUser getUserById(int id);

    public void delete(int id) throws Exception;

    public AwUser updateUser(AwUser awUser);

    public void insertUser(AwUser awUser) throws Exception;

}
