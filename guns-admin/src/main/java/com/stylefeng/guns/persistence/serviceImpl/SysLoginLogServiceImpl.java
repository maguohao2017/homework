package com.stylefeng.guns.persistence.serviceImpl;

import com.stylefeng.guns.persistence.model.SysLoginLog;
import com.stylefeng.guns.persistence.dao.SysLoginLogMapper;
import com.stylefeng.guns.persistence.service.ISysLoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 *
 * @author maguohao123
 * @since 2018-11-13
 */
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements ISysLoginLogService {

}
