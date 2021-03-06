package com.stylefeng.guns.modular.folder.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.folder.service.IFolderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/folder")
public class FloderController extends BaseController {

    private String PREFIX = "/folder/";

    @Resource
    private IFolderService iFolderService;

    @RequestMapping("")
    public String index() {
        Integer roleId = ShiroKit.getUser().getRoleList().get(0);

        if(roleId == 6){
            return PREFIX + "folder_teacher.html";
        }else if(roleId == 7){
            return PREFIX + "folder_teacher.html";
        }else{
            return PREFIX + "folder_teacher.html";
        }
    }

    @RequestMapping("/folder_add")
    public String folder_add() {
        return PREFIX + "folder_teacher_add.html";
    }

    @RequestMapping("/folder_edit")
    public String folder_edit() {
        return PREFIX + "folder_teacher_edit.html";
    }

    @RequestMapping("/goHomework/{id}")
    public String goHomework(@PathVariable Integer id,Model model) {

        model.addAttribute("id",id);
        Integer roleId = ShiroKit.getUser().getRoleList().get(0);

        if(roleId == 6){
            return PREFIX + "homework_teacher.html";
        }else if(roleId == 7){
            return PREFIX + "homework_student.html";
        }else{
            return PREFIX + "homework_teacher.html";
        }
    }

    @RequestMapping("/folder_edit/{id}")
    public String class_edit(@PathVariable Integer id,Model model) {


        Map map = iFolderService.getFolder(id);
        model.addAttribute("id",map.get("folderName"));
        model.addAttribute("folderType",map.get("folderType"));
        model.addAttribute("folderName",map.get("folderName"));
        model.addAttribute("classNo",map.get("classNo"));
        model.addAttribute("remark",map.get("remark"));
        return PREFIX + "folder_teacher_edit.html";
    }


    @RequestMapping(value = "/getFolderList")
    @ResponseBody
    public List<Map<String, Object>> getFolderList() {

        List<Map<String, Object>> getFolderList = null;
        try {
            getFolderList = this.iFolderService.getFolderList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return getFolderList;
    }

    @RequestMapping(value = "/getFolderMap")
    @ResponseBody
    public Map<String, Object> getFolderMap() {

        Map<String, Object> getFolderMap = null;
        Integer userId = ShiroKit.getUser().getId();

        try {
            getFolderMap = this.iFolderService.getFolder(userId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return getFolderMap;
    }

    @RequestMapping(value = "/insertFolder")
    @ResponseBody
    public Integer insertFolder(@RequestBody Map map) {

        Integer no = 0;
        try {
            no = this.iFolderService.insertFolder(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    @RequestMapping(value = "/updateFolder")
    @ResponseBody
    public Integer updateFolder(@RequestBody Map map) {

        Integer no = 0;
        try {
            no = this.iFolderService.updateFolder(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    @RequestMapping(value = "/deleteFolder/{id}")
    @ResponseBody
    public Integer deleteFolder(@PathVariable Integer id) {

        Integer no = 0;
        try {
            no = this.iFolderService.deleteFolder(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }
}
