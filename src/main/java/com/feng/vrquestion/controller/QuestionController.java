package com.feng.vrquestion.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.feng.vrquestion.common.ErrorCode;
import com.feng.vrquestion.exception.BusinessException;
import com.feng.vrquestion.model.domain.Answerstatus;
import com.feng.vrquestion.model.domain.Question;
import com.feng.vrquestion.model.request.question.QuestionAnswer;
import com.feng.vrquestion.model.response.AnswerstatusResponse;
import com.feng.vrquestion.model.response.QuestionAnswerResponse;
import com.feng.vrquestion.service.AnswerstatusService;
import com.feng.vrquestion.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

    private final AnswerstatusService answerstatusService;

    @PostMapping("/getqus")
    public R<QuestionAnswerResponse> getQuestion(@RequestBody QuestionAnswer questionAnswer) {
        if(questionAnswer == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        QuestionAnswerResponse questionAnswerResponse = questionService.getQuestion(questionAnswer);
        return R.ok(questionAnswerResponse);
    }

//    @PostMapping("/answer")
//    public R<AnswerstatusResponse> judge(@RequestBody )
}
