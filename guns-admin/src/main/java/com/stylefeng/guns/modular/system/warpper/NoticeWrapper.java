package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;

import java.util.Map;

/**
 * 组织列表的包装
 *
 * @author maguohao
 * @date 2018年11月1日 18:10:31
 */
public class NoticeWrapper extends BaseControllerWarpper {

    public NoticeWrapper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        Integer creater = (Integer) map.get("creater");
        map.put("createrName", ConstantFactory.me().getUserNameById(creater));
    }

}
