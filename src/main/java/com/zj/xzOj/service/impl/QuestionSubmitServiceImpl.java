package com.zj.xzOj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.xzOj.common.ErrorCode;
import com.zj.xzOj.exception.BusinessException;
import com.zj.xzOj.mapper.QuestionSubmitMapper;
import com.zj.xzOj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zj.xzOj.model.entity.*;
import com.zj.xzOj.model.entity.QuestionSubmit;
import com.zj.xzOj.model.enums.QuestionSubmitLanguageEnum;
import com.zj.xzOj.model.enums.QuestionSubmitStatusEnum;
import com.zj.xzOj.service.QuestionSubmitService;
import com.zj.xzOj.service.QuestionService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * <p>
 * 题目提交 服务实现类
 * </p>
 *
 * @author zengjing
 * @since 2024-04-14
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit> implements QuestionSubmitService {

    @Resource
    private QuestionService questionService;

    /**
     * 提交题目
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        //判断编程语言是否合法
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum enumByValue = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (enumByValue==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"编程语言违法");
        }
        Long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        long userId = loginUser.getId();
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(language);
        questionSubmit.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean result = this.save(questionSubmit);
        if(!result){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"提交题目失败");
        }
        return questionSubmit.getId();
    }

}
