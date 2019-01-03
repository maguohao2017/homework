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

    List<Map<String, Object>> getHomeworkList(@Param("folderId") String folderId);

    List<Map<String, Object>> getHomeworkList_student(@Param("folderId") String folderId);

    Integer insertHomework(Map map);

    Integer insertHomework_student(Map map);

}