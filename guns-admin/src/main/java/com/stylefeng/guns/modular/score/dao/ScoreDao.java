package com.stylefeng.guns.modular.score.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author maguohao
 * @since 2018-11-19
 */
public interface ScoreDao {


    List<Map<String, Object>> getScoreList(Integer folderId);

    Integer insertScore(Map map);

    Integer updateScore(Map map);

    Integer deleteScore(Integer id);

}