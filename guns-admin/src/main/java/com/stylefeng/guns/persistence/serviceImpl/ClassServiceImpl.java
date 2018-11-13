package com.stylefeng.guns.persistence.serviceImpl;

import com.stylefeng.guns.persistence.model.Class;
import com.stylefeng.guns.persistence.dao.ClassMapper;
import com.stylefeng.guns.persistence.service.IClassService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author maguohao123
 * @since 2018-11-13
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements IClassService {

}
