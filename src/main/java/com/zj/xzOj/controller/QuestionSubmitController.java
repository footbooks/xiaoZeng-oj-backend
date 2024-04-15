package com.zj.xzOj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zj.xzOj.common.BaseResponse;
import com.zj.xzOj.common.ErrorCode;
import com.zj.xzOj.common.ResultUtils;
import com.zj.xzOj.exception.BusinessException;
import com.zj.xzOj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zj.xzOj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.zj.xzOj.model.entity.QuestionSubmit;
import com.zj.xzOj.model.entity.User;
import com.zj.xzOj.model.vo.QuestionSubmitVO;
import com.zj.xzOj.service.QuestionSubmitService;
import com.zj.xzOj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能提交
        final User loginUser = userService.getLoginUser(request);
        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(result);
    }
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest, HttpServletRequest request){
        long pageSize = questionSubmitQueryRequest.getPageSize();
        long current = questionSubmitQueryRequest.getCurrent();
        //查询提交信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, pageSize),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        User loginUser = userService.getLoginUser(request);
        //脱敏
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage,loginUser));
    }

}
