package com.feng.vrquestion.model.request.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class DoctorUserLoginRequest implements Serializable {

    /**
     * 账号（手动分配）
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    private static final long serialVersionUID = 1L;
}
