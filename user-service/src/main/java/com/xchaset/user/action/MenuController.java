package com.xchaset.user.action;

import com.xchaset.user.dto.MenuInfoDTO;
import com.xchaset.user.mapper.MenuInfoPOMapper;
import com.xchaset.user.mapper.MenuRoleRelationPOMapper;
import com.xchaset.user.vo.MenuInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xiaozhaoming on 2018/12/16.
 */
@RestController
public class MenuController {

    MenuInfoPOMapper menuInfoPOMapper;

    @Autowired
    private MenuRoleRelationPOMapper menuRoleRelationPOMapper;
    /**
     *
     * @return
     */
    public String addMenu(@RequestBody MenuInfoVO menuInfoVO){

        return null;
    }

    @GetMapping("/menu")
    public List<MenuInfoDTO> getMenuInfo(){
        List<MenuInfoDTO> dtos = menuRoleRelationPOMapper.selectMenuInfoListByRoleCodes()
                .stream().sorted((o1,o2) -> o1.getItemCode().compareTo(o2.getItemCode())).collect(Collectors.toList());
        List<MenuInfoDTO> menuInfoDTOS = recurrenceMenu(dtos, dtos.get(0));
        return menuInfoDTOS;
    }

    private List<MenuInfoDTO> recurrenceMenu(List<MenuInfoDTO> menuInfoDTOList, MenuInfoDTO rootMenu) {
        List<MenuInfoDTO> childrenMenus = new ArrayList<>();
        for (MenuInfoDTO menuInfoDTO : menuInfoDTOList) {
            if (!StringUtils.isEmpty(rootMenu.getItemCode())
                    && rootMenu.getItemCode().equals(menuInfoDTO.getParentCode())){
                childrenMenus.add(menuInfoDTO);
                List<MenuInfoDTO> menuInfoDTOS = recurrenceMenu(menuInfoDTOList,menuInfoDTO);
                menuInfoDTO.setChildrenList(menuInfoDTOS);
            }
        }
        return childrenMenus;
    }

}
