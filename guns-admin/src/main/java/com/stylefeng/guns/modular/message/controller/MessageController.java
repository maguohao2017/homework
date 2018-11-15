package com.stylefeng.guns.modular.message.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.system.model.*;
import com.stylefeng.guns.modular.system.service.IDeptService;
import com.stylefeng.guns.modular.system.service.IRoleService;
import com.stylefeng.guns.modular.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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

    private String PREFIX = "/message/";

    @Autowired
    private IUserService userService;

    @Autowired
    private IDeptService deptService;

    @Autowired
    private IRoleService roleService;

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

        Map map = new HashMap<>();
        User user = new User();
        Dept dept = new Dept();
        Role role = new Role();

        try {
            String account = ShiroKit.getUser().account;

            user = userService.getByAccount(account);

            dept = deptService.selectById(user.getDeptid());

            role = roleService.selectById(user.getRoleid());

            map.put("user",user);
            map.put("dept",dept);
            map.put("role",role);

        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
