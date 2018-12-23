package com.xchaset.user.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by xiaozhaoming on 2018/12/16.
 */
@Data
public class MenuInfoDTO {

    private String itemCode;

    private String parentCode;

    private String itemName;

    private String itemLink;

    private String itemImgUrl;

    private String remark;

    private List<MenuInfoDTO> childrenList;

}
