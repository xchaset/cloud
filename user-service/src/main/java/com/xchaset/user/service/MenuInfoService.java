package com.xchaset.user.service;

import com.xchaset.user.vo.MenuInfoVO;
import org.springframework.stereotype.Service;

/**
 * Created by xiaozhaoming on 2018/12/16.
 */
public interface MenuInfoService {

    /**
     * 新增菜单项
     * @return
     */
    Integer addMenu(MenuInfoVO menuInfoVO);

    /**
     * 删除菜单
     * @param itemCode
     * @return
     */
    Integer deleteMenu(String itemCode);

    /**
     * 修改菜单
     * @param menuInfoVO
     * @return
     */
    Integer updateMenu(MenuInfoVO menuInfoVO);









}
