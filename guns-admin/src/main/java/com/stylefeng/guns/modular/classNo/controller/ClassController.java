package com.stylefeng.guns.modular.classNo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.classNo.service.IClassNoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;
import javax.annotation.Resource;
import java.util.HashMap;
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
    public String index() {

        String roleId = ShiroKit.getUser().getRoleNames().get(0);

        if(roleId == "6"){
            return PREFIX + "class_teacher.html";
        }else if(roleId == "7"){
            return PREFIX + "class_student.html";
        }else{
            return PREFIX + "class_teacher.html";
        }
    }

    @RequestMapping("/class_student")
    public String class_student() {
        return PREFIX + "class_student.html";
    }

    @RequestMapping("/class_add")
    public String class_add() {
        return PREFIX + "class_teacher_add.html";
    }

    @RequestMapping("/class_edit/{id}")
    public String class_edit(@PathVariable Integer id,Model model) {


        Map map = iclassNoService.getClassEdit(id);
        model.addAttribute("id",map.get("id"));
        model.addAttribute("classNo",map.get("classNo"));
        model.addAttribute("classGrade",map.get("classGrade"));
        model.addAttribute("classYear",map.get("classYear"));
        return PREFIX + "class_teacher_edit.html";
    }


    @RequestMapping(value = "/getClassList")
    @ResponseBody
    public List<Map<String, Object>> getClassList() {

        List<Map<String, Object>> getClassList = null;
        Integer userId = ShiroKit.getUser().getId();

        try {
            getClassList = this.iclassNoService.getClassList(userId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return getClassList;
    }

    @RequestMapping(value = "/getClassMap")
    @ResponseBody
    public Map<String, Object> getClassMap() {

        Map<String, Object> getClass = null;
        Integer userId = null;
        String roleId = ShiroKit.getUser().getRoleNames().get(0);

        if(roleId == "学生"){
            userId = ShiroKit.getUser().getId();
        }
        try {
            getClass = this.iclassNoService.getClass(userId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return getClass;
    }

    @RequestMapping(value = "/insertClass/{params}")
    @ResponseBody
    public Integer insertClass(@PathVariable String params) {
        JSONObject json = JSON.parseObject(params);
        Map map = new HashMap<>(json);
        Integer userId = ShiroKit.getUser().id;
        map.put("userId",userId);
        Integer no = 0;
        try {
            no = this.iclassNoService.insertClass(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    @RequestMapping(value = "/updateClass/{params}")
    @ResponseBody
    public Integer updateClass(@PathVariable String params) {
        JSONObject json = JSON.parseObject(params);
        Map map = new HashMap<>(json);
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
