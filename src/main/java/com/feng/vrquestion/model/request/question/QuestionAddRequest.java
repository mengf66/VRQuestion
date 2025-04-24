package com.feng.vrquestion.model.request.question;

import com.baomidou.mybatisplus.annotation.TableField;
import com.feng.vrquestion.model.common.Option;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QuestionAddRequest implements Serializable {
    /**
     * 题目内容
     */
    private String questionText;

    /**
     * 选项
     */
    private List<Option> options;

    /**
     * 题目答案
     */
    private Option answer;

    /**
     * 限制时长
     */
    private Long timeLimit;

    /**
     * 对应的视频编号
     */
    private Long videoId;

    private static final long serialVersionUID = 1L;
}
