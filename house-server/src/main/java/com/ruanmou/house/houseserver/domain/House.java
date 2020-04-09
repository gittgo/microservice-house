package com.ruanmou.house.houseserver.domain;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ProjectName: microservice-house
 * @Auther: GERRY
 * @Date: 2018/11/12 20:24
 * @Description:
 */
@Getter
@Setter
public class House {
    @Id
    @KeySql(useGeneratedKeys=true) // 主键自动增长
    private Integer id;
    private String name;
    private String type;
    private int price;
    private String image;
    private String area;
    private Integer beds;
    private Integer baths;
    private Double rating;
    private String remarks;
    private String properties;
    private String floorPlan;
    private String tags;
    private Date createTime;
    private Integer cityId;
    private Integer communityId;
}
