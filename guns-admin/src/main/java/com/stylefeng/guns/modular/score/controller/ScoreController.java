package com.stylefeng.guns.modular.score.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.score.service.IScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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
@RequestMapping("/score")
public class ScoreController extends BaseController {

    private String PREFIX = "/score/";

    @Resource
    private IScoreService iScoreService;

    @RequestMapping("")
    public String index() {
        Integer roleId = ShiroKit.getUser().getRoleList().get(0);

        if(roleId == 6){
            return PREFIX + "score_teacher.html";
        }else if(roleId == 7){
            return PREFIX + "score_teacher.html";
        }else{
            return PREFIX + "score_teacher.html";
        }
    }

    @RequestMapping("/score_add")
    public String score_add() {
        return PREFIX + "score_teacher_add.html";
    }

    @RequestMapping("/score_edit")
    public String score_edit() {
        return PREFIX + "score_teacher_edit.html";
    }


    @RequestMapping(value = "/getScoreList")
    @ResponseBody
    public List<Map<String, Object>> getScoreList() {

        List<Map<String, Object>> getScoreList = null;
        try {
            getScoreList = this.iScoreService.getScoreList(ShiroKit.getUser().getId());
        }catch (Exception e){
            e.printStackTrace();
        }

        return getScoreList;
    }

    @RequestMapping(value = "/insertScore")
    @ResponseBody
    public Integer insertScore(@RequestBody Map map) {

        Integer no = 0;
        try {
            no = this.iScoreService.insertScore(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    @RequestMapping(value = "/updateScore")
    @ResponseBody
    public Integer updateScore(@RequestBody Map map) {

        Integer no = 0;
        try {
            no = this.iScoreService.updateScore(map);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    @RequestMapping(value = "/deleteScore/{id}")
    @ResponseBody
    public Integer deleteScore(@PathVariable Integer id) {

        Integer no = 0;
        try {
            no = this.iScoreService.deleteScore(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }
}
