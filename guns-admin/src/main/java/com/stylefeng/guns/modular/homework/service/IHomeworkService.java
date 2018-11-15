package com.stylefeng.guns.modular.homework.service;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * @author maguohao
 * @Date 2018年11月30日 下午1:11:57
 */
public interface IHomeworkService {

    List<Map<String, Object>> getHomeworkList(Integer folderId);

    Integer insertHomework(Map map);

    Integer updateHomework(Map map);

    Integer deleteHomework(Integer id);
}