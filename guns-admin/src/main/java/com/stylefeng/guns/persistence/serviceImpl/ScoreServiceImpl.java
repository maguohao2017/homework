package com.stylefeng.guns.persistence.serviceImpl;

import com.stylefeng.guns.persistence.model.Score;
import com.stylefeng.guns.persistence.dao.ScoreMapper;
import com.stylefeng.guns.persistence.service.IScoreService;
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
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements IScoreService {

}
