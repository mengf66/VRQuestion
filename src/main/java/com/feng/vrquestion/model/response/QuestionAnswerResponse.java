package com.feng.vrquestion.model.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.feng.vrquestion.model.common.Option;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QuestionAnswerResponse implements Serializable {
    /**
     * 题目编号
     */
    private Long id;

    /**
     * 题目内容
     */
    private String questionText;

    /**
     * 选项
     */
    @TableField(value = "options")
    private List<Option> options;

    /**
     * 限制时长
     */
    private Long timeLimit;

    private static final long serialVersionUID = 1L;
}
