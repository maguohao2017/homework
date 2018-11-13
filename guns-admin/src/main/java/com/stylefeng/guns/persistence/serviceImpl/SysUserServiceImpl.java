package com.stylefeng.guns.persistence.serviceImpl;

import com.stylefeng.guns.persistence.model.SysUser;
import com.stylefeng.guns.persistence.dao.SysUserMapper;
import com.stylefeng.guns.persistence.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author maguohao123
 * @since 2018-11-13
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
