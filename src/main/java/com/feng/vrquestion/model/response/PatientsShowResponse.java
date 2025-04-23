package com.feng.vrquestion.model.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class PatientsShowResponse implements Serializable {
    /**
     * 病人编号
     */
    private String id;

    /**
     * 病人姓名
     */
    private String patientName;

    /**
     * 男（1）女（0）
     */
    private Integer gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 症状
     */
    private String symptoms;

    /**
     * 视频完成度：0（未完成）1（完成）
     */
    private Integer isComplete;

    /**
     * 答题总数
     */
    private Integer answerNum;

    /**
     * 正确题目总数
     */
    private Integer correctNum;

    private static final long serialVersionUID = 1L;
}
