package com.zj.xzOj.judge;

import com.zj.xzOj.model.entity.QuestionSubmit;
import com.zj.xzOj.model.vo.QuestionSubmitVO;

/**
 * 判题服务
 */
public interface JudgeService {
    QuestionSubmit doJudge(long questionSubmitId);
}
