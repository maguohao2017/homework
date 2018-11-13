package com.stylefeng.guns.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author maguohao123
 * @since 2018-11-13
 */
public class Score extends Model<Score> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String score;
    private String status;
    @TableField("create_time")
    private Date createTime;
    @TableField("perusal_time")
    private Date perusalTime;
    private String remark;
    @TableField("homework_id")
    private Integer homeworkId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPerusalTime() {
        return perusalTime;
    }

    public void setPerusalTime(Date perusalTime) {
        this.perusalTime = perusalTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Score{" +
        "id=" + id +
        ", score=" + score +
        ", status=" + status +
        ", createTime=" + createTime +
        ", perusalTime=" + perusalTime +
        ", remark=" + remark +
        ", homeworkId=" + homeworkId +
        "}";
    }
}
