package com.stylefeng.guns.modular.folder.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author maguohao
 * @since 2018-12-19
 */
public interface FolderDao {


    List<Map<String, Object>> getFolderList();

    Integer insertFolder(Map map);

    Integer updateFolder(Map map);

    Integer deleteFolder(Integer id);



}