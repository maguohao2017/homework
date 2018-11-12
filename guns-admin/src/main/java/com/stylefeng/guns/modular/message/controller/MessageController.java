package com.stylefeng.guns.modular.message.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.checkTime.service.ICheckTimeService;
import com.stylefeng.guns.modular.system.model.User;
import com.stylefeng.guns.modular.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 个人信息控制器
 *
 * @author maguohao
 * @Date 2018年11月17日20:27:22
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    private static String PREFIX = "/message/";

    @Autowired
    private IUserService userService;

    @RequestMapping("")
    public String index() {
        return PREFIX + "message.html";
    }

    /**
     * 获取个人信息
     */
    @RequestMapping(value = "/map")
    @ResponseBody
    public Object map() {

        User user = new User();
        try {
            String account = ShiroKit.getUser().account;

            user = userService.getByAccount(account);


        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
