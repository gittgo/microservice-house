package com.ruanmou.house.houseserver.common.mapper;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface HouseBaseMapper<T> extends BaseMapper<T> ,InsertListMapper<T>,IdsMapper<T>{


}
