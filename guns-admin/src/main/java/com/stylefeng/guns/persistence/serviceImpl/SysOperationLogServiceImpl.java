package com.stylefeng.guns.persistence.serviceImpl;

import com.stylefeng.guns.persistence.model.SysOperationLog;
import com.stylefeng.guns.persistence.dao.SysOperationLogMapper;
import com.stylefeng.guns.persistence.service.ISysOperationLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author maguohao123
 * @since 2018-11-13
 */
@Service
public class SysOperationLogServiceImpl extends ServiceImpl<SysOperationLogMapper, SysOperationLog> implements ISysOperationLogService {

}
