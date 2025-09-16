package com.feng.vrquestion.model.response;

import com.feng.vrquestion.model.common.Option;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnswerstatusShowResponse implements Serializable {

    /**
     * 题目
     */
    private String question;

    /**
     * 病人姓名
     */
    private String patientName;

    /**
     * 病人的回答（ABCD或无）
     */
    private Option answer;

    /**
     * 回答的状态（0 - 错误 1- 正确 2 - 超时未作答）
     */
    private Integer correct;

    private static final long serialVersionUID = 1L;
}
