package com.stylefeng.guns.modular.classNo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author maguohao
 * @since 2018-08-19
 */
public interface ClassNoDao {


    List<Map<String, Object>> getClassList(Integer userId);

    Integer insertClass(Map map);

    Integer updateClass(Map map);

    Integer deleteClass(Integer id);



}