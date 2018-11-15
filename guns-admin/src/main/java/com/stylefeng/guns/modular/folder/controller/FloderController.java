package com.stylefeng.guns.modular.folder.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.folder.service.IFolderService;
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
@RequestMapping("/folder")
public class FloderController extends BaseController {

    private String PREFIX = "/folder/";

    @Resource
    private IFolderService iFolderService;

    @RequestMapping("")
    public String check_time_staff() {
        return PREFIX + "folder.html";
    }

    @RequestMapping("/folder_add")
    public String check_history_staff() {
        return PREFIX + "folder_add.html";
    }

    @RequestMapping("/folder_edit")
    public String check_time_boss() {
        return PREFIX + "folder_edit.html";
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
