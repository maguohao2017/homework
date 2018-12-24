package com.stylefeng.guns.modular.score.service;


import java.util.List;
import java.util.Map;

/**
 *
 * @author maguohao
 * @Date 2018年11月12日 下午1:11:57
 */
public interface IScoreService {

    List<Map<String, Object>> getScoreList(Integer userId);

    Map<String, Object> getScore(Integer id);

    Integer insertScore(Map map);

    Integer updateScore(Map map);

    Integer deleteScore(Integer id);
}