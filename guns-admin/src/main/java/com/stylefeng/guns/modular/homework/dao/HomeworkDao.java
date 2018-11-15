package com.stylefeng.guns.modular.homework.dao;

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
public interface HomeworkDao {


    List<Map<String, Object>> getHomeworkList(Integer folderId);

    Integer insertHomework(Map map);

    Integer updateHomework(Map map);

    Integer deleteHomework(Integer id);



}