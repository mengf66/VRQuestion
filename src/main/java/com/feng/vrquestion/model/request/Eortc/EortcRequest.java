package com.feng.vrquestion.model.request.Eortc;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class EortcRequest {

    /**
     *
     */
    private String patientName;

    /**
     * 病人编号
     */
    private String patientId;

    /**
     * 床号
     */
    private Integer bedNum;

    /**
     * 答案列表
     */
    private List<String> answerList;

    private static final long serialVersionUID = 1L;
}
