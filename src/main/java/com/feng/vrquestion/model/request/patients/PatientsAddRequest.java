package com.feng.vrquestion.model.request.patients;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class PatientsAddRequest implements Serializable {
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

    private static final long serialVersionUID = 1L;
}
