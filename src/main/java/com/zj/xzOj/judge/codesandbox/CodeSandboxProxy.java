package com.zj.xzOj.judge.codesandbox;

import cn.hutool.http.HttpResponse;
import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CodeSandboxProxy implements CodeSandbox{

    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox){
        this.codeSandbox=codeSandbox;
    }
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest excuteCodeRequest) {
        log.info("代码沙箱请求信息:"+excuteCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(excuteCodeRequest);
        log.info("代码沙箱响应信息："+executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
