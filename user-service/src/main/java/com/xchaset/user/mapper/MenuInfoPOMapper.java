package com.xchaset.user.mapper;

import com.xchaset.user.po.MenuInfoPO;

public interface MenuInfoPOMapper {
    int deleteByPrimaryKey(String idMenuInfo);

    int insert(MenuInfoPO record);

    int insertSelective(MenuInfoPO record);

    MenuInfoPO selectByPrimaryKey(String idMenuInfo);

    int updateByPrimaryKeySelective(MenuInfoPO record);

    int updateByPrimaryKey(MenuInfoPO record);
}