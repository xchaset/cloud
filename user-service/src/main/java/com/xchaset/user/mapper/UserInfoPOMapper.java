package com.xchaset.user.mapper;

import com.xchaset.user.po.UserInfoPO;

public interface UserInfoPOMapper {
    int deleteByPrimaryKey(String idUserInfo);

    int insert(UserInfoPO record);

    int insertSelective(UserInfoPO record);

    UserInfoPO selectByPrimaryKey(String idUserInfo);

    int updateByPrimaryKeySelective(UserInfoPO record);

    int updateByPrimaryKey(UserInfoPO record);
}