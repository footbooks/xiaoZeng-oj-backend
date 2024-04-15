package com.zj.xzOj.model.dto.questionsubmit;

import com.zj.xzOj.common.PageRequest;
import com.zj.xzOj.model.dto.question.JudgeCase;
import com.zj.xzOj.model.dto.question.JudgeConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 查询请求
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    private Long questionId;

    private String language;

    private Integer status;

    private Long userId;

    private static final long serialVersionUID = 1L;
}