package com.eatmans.sms.mapper;

import com.eatmans.sms.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author eatmans
 * @version 1.0
 * @date 2021/6/2
 */
@Mapper
public interface UserMapper {

    /**
     * 获取用户信息
     *
     * @param userPhone 手机号码
     * @return 用户实体类
     */
    User getUserByPhone(String userPhone);
}
