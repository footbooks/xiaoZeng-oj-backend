package com.zj.xzOj.model.dto.question;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 更新请求
 *
 * 
 */
@Data
public class QuestionUpdateRequest implements Serializable {

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