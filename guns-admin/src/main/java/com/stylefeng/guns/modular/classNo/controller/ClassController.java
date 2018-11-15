package com.stylefeng.guns.modular.classNo.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.classNo.service.IClassNoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author maguohao
 * @Date 2018年11月17日20:27:22
 */
@Controller
@RequestMapping("/class")
public class ClassController extends BaseController {

    private String PREFIX = "/class/";

    @Resource
    private IClassNoService iclassNoService;
    
    @RequestMapping("")
    public String check_time_staff() {
        return PREFIX + "class.html";
    }

    @RequestMapping("/class_add")
    public String check_history_staff() {
        return PREFIX + "class_add.html";
    }

    @RequestMapping("/class_edit")
    public String check_time_boss() {
        return PREFIX + "class_edit.html";
    }


    @RequestMapping(value = "/getClassList")
    @ResponseBody
    public List<Map<String, Object>> getClassList() {

        List<Map<String, Object>> getClassList = null;
        try {
            getClassList = this.iclassNoService.getClassList(ShiroKit.getUser().getId());
        }catch (Exception e){
            e.printStackTrace();
        }

        return getClassList;
    }

    @RequestMapping(value = "/insertClass")
    @ResponseBody
    public Integer insertClass(@RequestBody Map map) {

        Integer no = 0;
        try {
            no = this.iclassNoService.insertClass(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    @RequestMapping(value = "/updateClass")
    @ResponseBody
    public Integer updateClass(@RequestBody Map map) {

        Integer no = 0;
        try {
            no = this.iclassNoService.updateClass(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    @RequestMapping(value = "/deleteClass/{id}")
    @ResponseBody
    public Integer deleteClass(@PathVariable Integer id) {

        Integer no = 0;
        try {
            no = this.iclassNoService.deleteClass(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }
}
