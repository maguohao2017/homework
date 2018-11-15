package com.stylefeng.guns.modular.homework.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.classNo.service.IClassNoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 打卡控制器
 *
 * @author maguohao
 * @Date 2018年11月17日20:27:22
 */
@Controller
@RequestMapping("/classNo")
public class HomeworkController extends BaseController {

    private String PREFIX = "/classNo/";

    @Resource
    private IClassNoService iclassNoService;
    /**
     * 跳转员工打卡页面
     */
    @RequestMapping("/check_time_staff")
    public String check_time_staff() {
        return PREFIX + "check_time_staff.html";
    }
    /**
     * 跳转员工历史打卡信息页面
     */
    @RequestMapping("/check_history_staff")
    public String check_history_staff() {
        return PREFIX + "check_history_staff.html";
    }

    /**
     * 跳转经理打卡页面
     */
    @RequestMapping("/check_time_boss")
    public String check_time_boss() {
        return PREFIX + "check_time_boss.html";
    }



    /**
     * 新增员工打卡记录
     */
    @RequestMapping(value = "/insertInfo")
    @ResponseBody
    public Integer insertInfo() {

        Integer userid = ShiroKit.getUser().getId();
        Integer status = 1;
        Integer no = 0;
        try {
            no = this.iclassNoService.insertInfo(userid,status);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }


    /**
     * 经理审批打卡记录
     */
    @RequestMapping(value = "/update_boss/{id}")
    @ResponseBody
    public Integer update(Integer id) {

        Integer status = 10;
        Integer no = 0;
        try {
            no = this.iclassNoService.update(id,status);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }
}
