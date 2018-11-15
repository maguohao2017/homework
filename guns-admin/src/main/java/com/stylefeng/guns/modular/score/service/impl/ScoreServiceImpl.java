package com.stylefeng.guns.modular.Score.service.impl;

import com.stylefeng.guns.modular.classNo.dao.ClassNoDao;
import com.stylefeng.guns.modular.classNo.service.IClassNoService;
import com.stylefeng.guns.modular.score.dao.ScoreDao;
import com.stylefeng.guns.modular.score.service.IScoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class ScoreServiceImpl implements IScoreService {

    @Resource
    ScoreDao ScoreDao;

    @Override
    public List<Map<String, Object>> getScoreList(Integer userId){
        return this.ScoreDao.getScoreList(userId);
    }

    @Override
    public Integer insertScore(Map map){
        return this.ScoreDao.insertScore(map);
    }

    @Override
    public Integer updateScore(Map map){
        return this.ScoreDao.updateScore(map);
    }

    @Override
    public Integer deleteScore(Integer id){
        return this.ScoreDao.deleteScore(id);
    }

}