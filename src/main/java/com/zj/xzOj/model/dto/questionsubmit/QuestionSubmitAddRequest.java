package com.zj.xzOj.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionSubmitAddRequest implements Serializable {
    private String language;
    private String code;
    private Long questionId;
    private static final long serialVersionUID = 1L;
}
