package com.xchaset.user.vo;

import lombok.Data;

/**
 * Created by xiaozhaoming on 2018/12/16.
 */
@Data
public class MenuInfoVO {

    private String itemCode;

    private String parentCode;

    private String itemName;

    private String itemLink;

    private String itemImgUrl;

    private String remark;

    private Boolean isEnabled;
}
