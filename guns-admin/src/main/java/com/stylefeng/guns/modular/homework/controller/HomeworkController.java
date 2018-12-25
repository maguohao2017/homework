package com.stylefeng.guns.modular.homework.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.homework.service.IHomeworkService;
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
@RequestMapping("/homework")
public class HomeworkController extends BaseController {

    private String PREFIX = "/homework/";

    @Resource
    private IHomeworkService iHomeworkService;

    @RequestMapping("")
    public String index() {
        String roleId = ShiroKit.getUser().getRoleNames().get(0);

        if(roleId == "6"){
            return PREFIX + "homework_teacher.html";
        }else if(roleId == "7"){
            return PREFIX + "homework_student.html";
        }else{
            return PREFIX + "homework_teacher.html";
        }
    }

    @RequestMapping("/list/{id}")
    public String list(@PathVariable String id, Model model) {
        model.addAttribute("id",id);
        return PREFIX + "homework_list.html";
    }

    @RequestMapping("/upload")
    public String upload() {
        return PREFIX + "homework_upload.html";
    }

    @RequestMapping("/download")
    public String download() {
        return PREFIX + "homework_download.html";
    }

    @RequestMapping("/homework_add")
    public String homework_add() {
        return PREFIX + "homework_teacher_add.html";
    }

    @RequestMapping("/homework_edit")
    public String homework_edit() {
        return PREFIX + "homework_teacher_edit.html";
    }


    @RequestMapping(value = "/getHomeworkList/{id}")
    @ResponseBody
    public List<Map<String, Object>> getHomeworkList(@PathVariable String id) {

        List<Map<String, Object>> getHomeworkList = null;
        try {
            getHomeworkList = this.iHomeworkService.getHomeworkList(Integer.parseInt(id));
        }catch (Exception e){
            e.printStackTrace();
        }

        return getHomeworkList;
    }

    @RequestMapping(value = "/insertHomework")
    @ResponseBody
    public Integer insertHomework(@RequestBody Map map) {

        Integer no = 0;
        try {
            no = this.iHomeworkService.insertHomework(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    @RequestMapping(value = "/updateHomework")
    @ResponseBody
    public Integer updateHomework(@RequestBody Map map) {

        Integer no = 0;
        try {
            no = this.iHomeworkService.updateHomework(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    @RequestMapping(value = "/deleteHomework/{id}")
    @ResponseBody
    public Integer deleteHomework(@PathVariable Integer id) {

        Integer no = 0;
        try {
            no = this.iHomeworkService.deleteHomework(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return no;
    }
}
