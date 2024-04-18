package com.zj.xzOj.judge;

import cn.hutool.json.JSONUtil;
import com.zj.xzOj.common.ErrorCode;
import com.zj.xzOj.exception.BusinessException;
import com.zj.xzOj.judge.codesandbox.CodeSandbox;
import com.zj.xzOj.judge.codesandbox.CodeSandboxFactory;
import com.zj.xzOj.judge.codesandbox.CodeSandboxProxy;
import com.zj.xzOj.judge.codesandbox.JudgeManager;
import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeResponse;
import com.zj.xzOj.judge.strategy.JudgeContext;
import com.zj.xzOj.model.dto.question.JudgeCase;
import com.zj.xzOj.judge.codesandbox.model.JudgeInfo;
import com.zj.xzOj.model.entity.Question;
import com.zj.xzOj.model.entity.QuestionSubmit;
import com.zj.xzOj.model.enums.JudgeInfoMessageEnum;
import com.zj.xzOj.model.enums.QuestionSubmitStatusEnum;
import com.zj.xzOj.service.QuestionService;
import com.zj.xzOj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JudgeServiceImpl implements JudgeService {
    @Resource
    private QuestionService questionService;
    @Resource
    private QuestionSubmitService questionSubmitService;
    @Resource
    private JudgeManager judgeManager;
    @Value("${codesandbox.type:example}")
    private String type;
    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        //1.参数校验
        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
        if(questionSubmit==null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"题目提交信息不存在");
        }
        Long questionId = questionSubmit.getQuestionId();
        Question question = questionService.getById(questionId);
        if(question==null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"题目不存在");
        }
        //2.更改题目提交状态（只提交等待判题的代码）
        if(!questionSubmit.getStatus().equals(QuestionSubmitStatusEnum.WAITING.getValue())){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"代码已提交");
        }
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean update = questionSubmitService.updateById(questionSubmitUpdate);
        if(!update){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"修改提交状态异常");
        }
        //3.调用代码沙箱,获取代码沙箱执行结果
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        CodeSandboxProxy codeSandboxProxy = new CodeSandboxProxy(codeSandbox);
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandboxProxy.executeCode(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutputList();
        //4.根据执行结果，获取判断结果
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setQuestion(question);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestionSubmit(questionSubmit);
        //策略选择
        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);
        //5.修改数据库中的判题结果
        questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        if (!judgeInfo.getMessage().equals(JudgeInfoMessageEnum.ACCEPTED)){
            questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.FAILED.getValue());
        }else{
            questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        }
        questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        update = questionSubmitService.updateById(questionSubmitUpdate);
        if(!update){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"修改提交状态异常");
        }
        QuestionSubmit questionSubmitResult = questionSubmitService.getById(questionSubmitId);
        return questionSubmitResult;
    }
}
