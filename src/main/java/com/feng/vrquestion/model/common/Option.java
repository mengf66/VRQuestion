package com.feng.vrquestion.model.common;

import lombok.Data;

import java.io.Serializable;

//选项辅助类
@Data
public class Option implements Serializable {

    private String choice;

    private String optionText;

    private static final long serialVersionUID = 1L;
}
