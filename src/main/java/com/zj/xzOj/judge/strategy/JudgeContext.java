package com.zj.xzOj.judge.strategy;

import com.zj.xzOj.model.dto.question.JudgeCase;
import com.zj.xzOj.judge.codesandbox.model.JudgeInfo;
import com.zj.xzOj.model.entity.Question;
import com.zj.xzOj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;
    private List<String> inputList;
    private List<String> outputList;
    private Question question;
    private List<JudgeCase> judgeCaseList;
    private QuestionSubmit questionSubmit;
}
