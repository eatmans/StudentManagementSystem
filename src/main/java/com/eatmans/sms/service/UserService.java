package com.eatmans.sms.service;

import com.eatmans.sms.domain.Result;
import org.springframework.stereotype.Service;

/**
 * @author eatmans
 * @version 1.0
 * @date 2021/6/2
 */
@Service
public interface UserService {

    /**
     * 登录接口
     *
     * @param userPhone 用户名
     * @param password 手机号码
     * @return 用户实体类
     */
    Result<?> login(String userPhone, String password);

    /**
     * 获取用户信息
     *
     * @param userPhone 手机号码
     * @return 用户实体类
     */
    Result<?> getUserByPhone(String userPhone);

}
