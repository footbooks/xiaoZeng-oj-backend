package com.zj.xzOj.judge.codesandbox.impl;

import com.zj.xzOj.judge.codesandbox.CodeSandbox;
import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 远程代码沙箱(实际调用代码沙箱）
 */
public class RemoteCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest excuteCodeRequest) {
        System.out.println("远程代码沙箱");
        return null;
    }
}