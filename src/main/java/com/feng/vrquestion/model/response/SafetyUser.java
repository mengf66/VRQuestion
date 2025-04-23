package com.feng.vrquestion.model.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class SafetyUser implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 账号（手动分配）
     */
    private String account;

    /**
     * 医生姓名
     */
    private String username;

    private static final long serialVersionUID = 1L;
}
