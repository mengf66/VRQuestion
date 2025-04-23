package com.feng.vrquestion.model.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.feng.vrquestion.model.common.Option;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnswerstatusResponse implements Serializable {

    /**
     * 病人Id
     */
    private String patientName;

    /**
     * 问题Id
     */
    private Long questionId;

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
