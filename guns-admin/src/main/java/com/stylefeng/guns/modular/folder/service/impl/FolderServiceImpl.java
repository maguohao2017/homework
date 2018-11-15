package com.stylefeng.guns.modular.folder.service.impl;

import com.stylefeng.guns.modular.folder.dao.FolderDao;
import com.stylefeng.guns.modular.folder.service.IFolderService;
import com.stylefeng.guns.modular.quit.dao.QuitDao;
import com.stylefeng.guns.modular.quit.service.IQuitService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class FolderServiceImpl implements IFolderService {

    @Resource
    FolderDao folderDao;

    @Override
    public List<Map<String, Object>> getFolderList(){
        return this.folderDao.getFolderList();
    }

    @Override
    public Integer insertFolder(Map map){
        return this.folderDao.insertFolder(map);
    }

    @Override
    public Integer updateFolder(Map map){
        return this.folderDao.updateFolder(map);
    }

    @Override
    public Integer deleteFolder(Integer id){
        return this.folderDao.deleteFolder(id);
    }

}