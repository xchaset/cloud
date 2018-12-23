package com.xchaset.user.mapper;

import com.xchaset.user.po.SysRolePO;

public interface SysRolePOMapper {
    int deleteByPrimaryKey(String idSysRole);

    int insert(SysRolePO record);

    int insertSelective(SysRolePO record);

    SysRolePO selectByPrimaryKey(String idSysRole);

    int updateByPrimaryKeySelective(SysRolePO record);

    int updateByPrimaryKey(SysRolePO record);
}