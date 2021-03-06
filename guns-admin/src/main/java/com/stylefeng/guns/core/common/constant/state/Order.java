package com.stylefeng.guns.core.common.constant.state;

/**
 * 数据库排序
 *
 * @author maguohao
 * @Date 2018年11月30日20:48:41
 */
public enum Order {

    ASC("asc"), DESC("desc");

    private String des;

    Order(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
