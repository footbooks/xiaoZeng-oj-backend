package com.zj.xzOj.model.dto.question;

import lombok.Data;

/**
 * 判题配置
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制（ms）
     */
    private Long timeLimit;
    /**
     * 内存限制（MB）
     */
    private Long memoryLimit;
    /**
     * 栈堆限制（MB）
     */
    private Long stackLimit;
}
