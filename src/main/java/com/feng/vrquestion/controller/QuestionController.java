package com.feng.vrquestion.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.feng.vrquestion.common.ErrorCode;
import com.feng.vrquestion.exception.BusinessException;
import com.feng.vrquestion.model.common.Option;
import com.feng.vrquestion.model.domain.Answerstatus;
import com.feng.vrquestion.model.domain.Question;
import com.feng.vrquestion.model.request.question.AnswerStatusDto;
import com.feng.vrquestion.model.request.question.AnswerstatusAddRequest;
import com.feng.vrquestion.model.request.question.QuestionAddRequest;
import com.feng.vrquestion.model.request.question.QuestionAnswer;
import com.feng.vrquestion.model.response.AnswerstatusResponse;
import com.feng.vrquestion.model.response.AnswerstatusShowResponse;
import com.feng.vrquestion.model.response.QuestionAnswerResponse;
import com.feng.vrquestion.service.AnswerstatusService;
import com.feng.vrquestion.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vqquestion/question")
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

    @PostMapping("/answer")
    public R<AnswerstatusResponse> judge(@RequestBody AnswerstatusAddRequest answerstatusAddRequest) {
        if(answerstatusAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        AnswerstatusResponse answerstatusResponse = answerstatusService.judge(answerstatusAddRequest);
        return R.ok(answerstatusResponse);
    }

    @PostMapping("/saveAnswer")
    public R<AnswerstatusResponse> saveAnswer(@RequestBody AnswerStatusDto answerStatusDto) {
        if(answerStatusDto == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        AnswerstatusResponse answerstatusResponse = answerstatusService.saveAnswer(answerStatusDto);
        return R.ok(answerstatusResponse);
    }

    @PostMapping("/add")
    public R<Long> addQuestion(@RequestBody QuestionAddRequest questionAddRequest) {
        if(questionAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        Question question = BeanUtil.copyProperties(questionAddRequest, Question.class);
        List<Option> options = questionAddRequest.getOptions();
        String jsonStr = JSONUtil.toJsonStr(options);
        question.setOptions(jsonStr);
        String jsonStr1 = JSONUtil.toJsonStr(questionAddRequest.getAnswer());
        question.setAnswer(jsonStr1);
        boolean save = questionService.save(question);
        if(!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "系统内部错误");
        }
        Long questionId = question.getId();
        return R.ok(questionId);
    }

    @GetMapping("/show/{pId}")
    public R<List<AnswerstatusShowResponse>> show(@PathVariable("pId") Long pId) {
        if(pId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "空参数");
        }
        List<AnswerstatusShowResponse> list = answerstatusService.show(pId);
        return R.ok(list);
    }
}
