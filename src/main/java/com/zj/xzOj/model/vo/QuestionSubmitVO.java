package com.zj.xzOj.model.vo;

import cn.hutool.json.JSONUtil;
import com.zj.xzOj.model.dto.questionsubmit.JudgeInfo;
import com.zj.xzOj.model.entity.QuestionSubmit;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class QuestionSubmitVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String language;

    private String code;

    private JudgeInfo judgeInfo;

    private Integer status;

    private Long questionId;

    private Long userId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;

    private UserVO userVO;

    private QuestionVO questionVO;
    /**
     * 包装类转对象
     */
    public static QuestionSubmit voToObj(QuestionSubmitVO questionSubmitVO) {
        if (questionSubmitVO == null) {
            return null;
        }
        QuestionSubmit questionSubmit = new QuestionSubmit();
        BeanUtils.copyProperties(questionSubmitVO, questionSubmit);
        JudgeInfo judgeInfo = questionSubmitVO.getJudgeInfo();
        if(judgeInfo!=null){
            questionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        }
        return questionSubmit;
    }

    /**
     * 对象转包装类
     */
    public static QuestionSubmitVO objToVo(QuestionSubmit questionSubmit) {
        if (questionSubmit == null) {
            return null;
        }
        QuestionSubmitVO questionSubmitVO = new QuestionSubmitVO();
        BeanUtils.copyProperties(questionSubmit, questionSubmitVO);
        questionSubmitVO.setJudgeInfo(JSONUtil.toBean(questionSubmit.getJudgeInfo(), JudgeInfo.class));
        return questionSubmitVO;
    }
}
