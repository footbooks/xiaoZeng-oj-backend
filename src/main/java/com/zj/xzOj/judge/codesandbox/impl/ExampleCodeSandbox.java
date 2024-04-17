package com.zj.xzOj.judge.codesandbox.impl;

import com.zj.xzOj.judge.codesandbox.CodeSandbox;
import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeResponse;
import com.zj.xzOj.model.dto.questionsubmit.JudgeInfo;
import com.zj.xzOj.model.enums.JudgeInfoMessageEnum;
import com.zj.xzOj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱
 */
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest excuteCodeRequest) {
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        List<String> inputList = excuteCodeRequest.getInputList();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("示例代码沙箱");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
