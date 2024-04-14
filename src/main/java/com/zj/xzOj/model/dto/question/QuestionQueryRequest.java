package com.zj.xzOj.model.dto.question;

import com.zj.xzOj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 查询请求
 */
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {

    private Long id;

    private String title;

    private String content;

    private List<String> tags;

    private String answer;

    private List<JudgeCase> judgeCase;

    private JudgeConfig judgeConfig;

    private Long userId;

    private static final long serialVersionUID = 1L;
}