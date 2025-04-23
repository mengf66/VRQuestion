package com.feng.vrquestion.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.feng.vrquestion.common.ErrorCode;
import com.feng.vrquestion.exception.BusinessException;
import com.feng.vrquestion.model.request.patients.PatientsAddRequest;
import com.feng.vrquestion.model.response.PatientsAddResponse;
import com.feng.vrquestion.model.response.PatientsShowResponse;
import com.feng.vrquestion.service.PatientsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@Slf4j
public class PatientsController {

    private final PatientsService patientsService;

    @PostMapping("/add")
    public R<PatientsAddResponse> addPatient(@RequestBody PatientsAddRequest patientsAddRequest, HttpServletRequest request) {
        if(patientsAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        PatientsAddResponse patientsAddResponse = patientsService.addPatient(patientsAddRequest, request);
        return R.ok(patientsAddResponse);
    }

    @GetMapping("/show")
    public R<List<PatientsShowResponse>> showPatients() {
        List<PatientsShowResponse> patients = patientsService.showPatients();
        return R.ok(patients);
    }
}
