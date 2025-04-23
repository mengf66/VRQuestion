package com.feng.vrquestion.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.feng.vrquestion.common.ErrorCode;
import com.feng.vrquestion.exception.BusinessException;
import com.feng.vrquestion.model.request.user.DoctorUserLoginRequest;
import com.feng.vrquestion.model.response.SafetyUser;
import com.feng.vrquestion.service.DoctorUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class DoctorUserController {

    private final DoctorUserService doctorUserService;

    @PostMapping("/login")
    public R<SafetyUser> login(@RequestBody DoctorUserLoginRequest doctorUserLoginRequest, HttpServletRequest request) {
        if(doctorUserLoginRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        return doctorUserService.login(doctorUserLoginRequest, request);
    }

}
