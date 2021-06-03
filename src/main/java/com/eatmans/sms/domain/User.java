package com.eatmans.sms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author eatmans
 * @version 1.0
 * @date 2021/6/2
 */
@Data
@ApiModel(description = "用户实体类")
public class User implements Serializable {

    private static final long serialVersionUID = 1963308473592628309L;

    @ApiModelProperty(value = "自增长ID")
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "手机号")
    private String userPhone;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "身份")
    private String identity;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}
