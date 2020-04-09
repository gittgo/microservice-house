package com.ruanmou.house.houseserver.service;

import com.ruanmou.house.houseserver.domain.User;

import java.util.List;

/**
 * @ProjectName: user-service
 * @Auther: GERRY
 * @Date: 2018/11/13 20:59
 * @Description:
 */
public interface UserService {
    // 根据用户id获取用户信息
    User getUserById(Long id);
    // 根据条件获取用户信息列表
    List<User> getUserByCondition(User user);
    // 用注册的接口
    boolean addAccount(User user, String enableUrl);
    // 激活账户
    boolean  enableAccount(String key);
    // 登录接口
    User login(String email, String password);
    // 鉴权接口
    User getLoginUserByToken(String token);
    // 登出
    void logout(String token);

}
