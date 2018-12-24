package com.stylefeng.guns.modular.classNo.service.impl;

import com.stylefeng.guns.modular.classNo.service.IClassNoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class ClassServiceImpl implements IClassNoService {

    @Resource
    com.stylefeng.guns.modular.classNo.dao.ClassNoDao ClassDao;

    @Override
    public List<Map<String, Object>> getClassList(Integer id){
        return this.ClassDao.getClassList(id);
    }

    @Override
    public Map<String, Object> getClass(Integer userId){
        return this.ClassDao.getClass(userId);
    }

    @Override
    public Map<String, Object> getClassEdit(Integer id){
        return this.ClassDao.getClassEdit(id);
    }

    @Override
    public Integer insertClass(Map map){
        return this.ClassDao.insertClass(map);
    }

    @Override
    public Integer updateClass(Map map){
        return this.ClassDao.updateClass(map);
    }

    @Override
    public Integer deleteClass(Integer id){
        return this.ClassDao.deleteClass(id);
    }

}