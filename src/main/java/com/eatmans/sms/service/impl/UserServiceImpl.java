package com.eatmans.sms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.eatmans.sms.domain.CodeMsg;
import com.eatmans.sms.domain.Result;
import com.eatmans.sms.domain.User;
import com.eatmans.sms.mapper.UserMapper;
import com.eatmans.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author eatmans
 * @version 1.0
 * @date 2021/6/2
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public Result<?> login(String userPhone, String password) {

        // 判断手机号码的情况
        if (StrUtil.isNullOrUndefined(userPhone) || userPhone.trim().isEmpty() || userPhone.length() != 11) {
            return Result.error(1000, "手机长度有误");
        }

        // 如果密码为空则直接返回
        if (StrUtil.isNullOrUndefined(password) || password.trim().isEmpty()) {
            return Result.error(1001, "密码为空");
        }

        User user = userMapper.getUserByPhone(userPhone);

        // 判断是否存在该用户
        if (user == null) {
            return Result.error(CodeMsg.MISSING_RECORD);
        }

        String key = "user_" + userPhone ;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        if (ValidationLogin(user, password)) {
            operations.set(key+ "abc", user, 5, TimeUnit.HOURS);
            if ("老板".equals(user.getIdentity())) {
                return Result.success(CodeMsg.SUCCESS, "登录成功：~~~欢迎老板使用~~~" + "abc");

            } else {
                return Result.success(CodeMsg.SUCCESS, user );
            }
        } else {
            return Result.error(1002, "用户信息错误");
        }

    }

    /**
     * 验证用户信息
     * @param user 用户实体
     * @param password 密码
     * @return
     */
    private boolean ValidationLogin(User user, String password) {
        return password.equals(user.getPassword());
    }

    /**
     * 根据手机号码获取用户信息
     * @param userPhone 手机号码
     * @return
     */
    public Result<?> getUserByPhone(String userPhone) {

        String key = "user_" + userPhone;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        //判断redis中是否有键为key的缓存
        boolean hasKey = redisTemplate.hasKey(key);
        User user;
        if (hasKey) {
            user = operations.get(key);
            return Result.success(CodeMsg.SUCCESS, user);
        } else {
            user = userMapper.getUserByPhone(userPhone);
            if (user == null) {
                return Result.error(CodeMsg.MISSING_RECORD);
            } else {
                // 写入缓存
                operations.set(key, user, 5, TimeUnit.HOURS);
                return Result.success(CodeMsg.SUCCESS, user);
            }
        }

    }


}
