package com.stylefeng.guns.modular.folder.service;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * @author maguohao
 * @Date 2018年11月1日 下午1:11:57
 */
public interface IFolderService {

    List<Map<String, Object>> getFolderList();

    Map<String, Object> getFolder(Integer userId);

    Integer insertFolder(Map map);

    Integer updateFolder(Map map);

    Integer deleteFolder(Integer id);
}