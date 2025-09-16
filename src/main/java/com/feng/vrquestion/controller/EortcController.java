package com.feng.vrquestion.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpResource;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.feng.vrquestion.common.ErrorCode;
import com.feng.vrquestion.exception.BusinessException;
import com.feng.vrquestion.model.domain.Eortc;
import com.feng.vrquestion.model.request.Eortc.EortcRequest;
import com.feng.vrquestion.service.EortcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
@RequestMapping("/Eortc")
@RequiredArgsConstructor
@Slf4j
public class EortcController {

    private final EortcService eortcService;

    @PostMapping("/vqquestion/saveanswer")
    public R<String> saveAnswer(@RequestBody EortcRequest eortc) {
        if(eortc == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String json = JSONUtil.toJsonStr(eortc.getAnswerList());
        Eortc saveE = BeanUtil.copyProperties(eortc, Eortc.class);
        saveE.setAnswerList(json);
        boolean save = eortcService.save(saveE);
        if(save) {
            return R.ok("保存成功");
        }
        return R.failed("保存失败");
    }

    @GetMapping("get/{id}")
    public void getData(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
        Eortc eortc = eortcService.lambdaQuery().eq(Eortc::getPatientId, id).one();
        HashMap<String, String> map = new HashMap<>();
        map.put("病人编号", eortc.getPatientId());
        map.put("姓名", eortc.getPatientName());
        map.put("床号", eortc.getBedNum()+"");

        List<String> answerList = JSONUtil.toList(eortc.getAnswerList(), String.class);
        int questionId = 1;
        for(String answer : answerList) {
            map.put("第" + questionId + "题", answer);
            questionId++;
        }
        List<HashMap<String, String>> list = new ArrayList<>();
        list.add(map);
        // 2. 设置响应头（关键！）
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        String fileName = eortc.getPatientId() + "-Eortcc.xlsx";
        // 中文文件名需URL编码（否则浏览器乱码）
        String encodedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename*=UTF-8''" + encodedFileName);

        // 3. 创建ExcelWriter并写入数据到响应流
        try (ExcelWriter writer = ExcelUtil.getWriter(true)) { // true表示xlsx格式
            writer.write(list);
            writer.flush(response.getOutputStream());
        }
    }

}
