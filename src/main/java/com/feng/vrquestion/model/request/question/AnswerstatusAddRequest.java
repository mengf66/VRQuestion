package com.feng.vrquestion.model.request.question;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.feng.vrquestion.model.common.Option;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnswerstatusAddRequest implements Serializable {

    /**
     * 病人Id
     */
    private Long patientId;

    /**
     * 问题Id
     */
    private Long questionId;

    /**
     * 病人的回答（ABCD或无）
     */
    private Option answer;

    private static final long serialVersionUID = 1L;
}
