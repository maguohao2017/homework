package com.stylefeng.guns.modular.classNo.service;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * @author maguohao
 * @Date 2018年11月30日 下午1:11:57
 */
public interface IClassNoService {

    List<Map<String, Object>> getClassList(Integer id);

    Map<String, Object> getClass(Integer userId);

    Integer insertClass(Map map);

    Integer updateClass(Map map);

    Integer deleteClass(Integer id);
}