package com.zj.xzOj.judge.codesandbox;

import com.zj.xzOj.judge.strategy.DefaultJudgeStrategy;
import com.zj.xzOj.judge.strategy.JavaLanguageJudgeStrategy;
import com.zj.xzOj.judge.strategy.JudgeContext;
import com.zj.xzOj.judge.strategy.JudgeStrategy;
import com.zj.xzOj.judge.codesandbox.model.JudgeInfo;
import com.zj.xzOj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {
    /**
     * 执行判题
     */
    public JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if(language.equals("java")){
            judgeStrategy=new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
