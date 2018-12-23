package com.xchaset.user.action;

import com.netflix.discovery.converters.Auto;
import com.xchaset.user.mapper.UserInfoPOMapper;
import com.xchaset.user.po.UserInfoPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaozhaoming on 2018/12/16.
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserInfoPOMapper userInfoPOMapper ;

    @PostMapping("/login")
    public String login(){
        return "sucess";
    }

    /**
     * 注册
     * @param userInfoPO
     * @return
     */
    @PostMapping("/register")
    public String register(@RequestBody UserInfoPO userInfoPO){
        log.info("register params is :{}" ,userInfoPO);
        int insert = userInfoPOMapper.insert(userInfoPO);
        return String.valueOf(insert);
    }
}
