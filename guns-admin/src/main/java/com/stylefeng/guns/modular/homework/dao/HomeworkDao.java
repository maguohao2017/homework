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


    List<Map<String, Object>> getHomeworkList(@Param("folderId") String folderId);

    List<Map<String, Object>> getHomeworkList_student(@Param("folderId") String folderId);

    Integer insertHomework(Map map);

    Integer insertHomework_student(Map map);


}