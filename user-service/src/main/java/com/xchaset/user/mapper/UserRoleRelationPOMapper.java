package com.xchaset.user.mapper;

import com.xchaset.user.po.UserRoleRelationPO;

public interface UserRoleRelationPOMapper {
    int deleteByPrimaryKey(String isUserRoleRelation);

    int insert(UserRoleRelationPO record);

    int insertSelective(UserRoleRelationPO record);

    UserRoleRelationPO selectByPrimaryKey(String isUserRoleRelation);

    int updateByPrimaryKeySelective(UserRoleRelationPO record);

    int updateByPrimaryKey(UserRoleRelationPO record);
}