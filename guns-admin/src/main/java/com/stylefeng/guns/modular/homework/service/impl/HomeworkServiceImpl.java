package com.stylefeng.guns.modular.homework.service.impl;

import com.stylefeng.guns.modular.classNo.dao.ClassNoDao;
import com.stylefeng.guns.modular.classNo.service.IClassNoService;
import com.stylefeng.guns.modular.homework.dao.HomeworkDao;
import com.stylefeng.guns.modular.homework.service.IHomeworkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class HomeworkServiceImpl implements IHomeworkService {

    @Resource
    HomeworkDao homeworkDao;

    @Override
    public List<Map<String, Object>> getHomeworkList(Integer folderId){
        return this.homeworkDao.getHomeworkList(folderId);
    }

    @Override
    public Integer insertHomework(Map map){
        return this.homeworkDao.insertHomework(map);
    }

    @Override
    public Integer updateHomework(Map map){
        return this.homeworkDao.updateHomework(map);
    }

    @Override
    public Integer deleteHomework(Integer id){
        return this.homeworkDao.deleteHomework(id);
    }

}