package com.zj.xzOj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.xzOj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.zj.xzOj.model.entity.QuestionSubmit;
import com.zj.xzOj.model.entity.User;

/**
 * <p>
 * 题目提交 服务类
 * </p>
 *
 * @author zengjing
 * @since 2024-04-14
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     *
     * 题目提交
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

}
