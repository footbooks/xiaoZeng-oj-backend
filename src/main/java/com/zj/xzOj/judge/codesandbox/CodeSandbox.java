package com.zj.xzOj.judge.codesandbox;

import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zj.xzOj.judge.codesandbox.model.ExecuteCodeResponse;

public interface CodeSandbox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest excuteCodeRequest);
}
