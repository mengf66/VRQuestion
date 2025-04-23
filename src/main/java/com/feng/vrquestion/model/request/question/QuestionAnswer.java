package com.feng.vrquestion.model.request.question;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionAnswer implements Serializable {

    /**
     * 视频完成度：0（未完成）1（完成）
     */
    private Integer isComplete;

    /**
     * 视频Id
     */
    private Integer videoId;

    /**
     * 病人编号
     */
    private String patientId;

    private static final long serialVersionUID = 1L;
}
