package com.ruanmou.house.houseserver.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;


@Data
public class User {
  @Id
  @KeySql(useGeneratedKeys = true)
  private Long id;
  private String  name;
  private String  phone;
  private String  email;
  private String  aboutme;
  private String  password;
  private String avatar;
  private Integer type;
  private Date    createTime;
  private Integer enable;

  @Transient
  private String  confirmPassword;
  @Transient
  private String token;
  @Transient // 激活链接
  private String enableUrl;
}
