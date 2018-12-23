package com.xchaset.user.mapper;

import com.xchaset.user.dto.MenuInfoDTO;
import com.xchaset.user.po.MenuRoleRelationPO;

import java.util.List;

public interface MenuRoleRelationPOMapper {
    int deleteByPrimaryKey(String idMenuRoleRelation);

    int insert(MenuRoleRelationPO record);

    int insertSelective(MenuRoleRelationPO record);

    MenuRoleRelationPO selectByPrimaryKey(String idMenuRoleRelation);

    int updateByPrimaryKeySelective(MenuRoleRelationPO record);

    int updateByPrimaryKey(MenuRoleRelationPO record);

    List<MenuInfoDTO> selectMenuInfoListByRoleCodes();
}