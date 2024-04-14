package com.zj.xzOj.model.vo;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zj.xzOj.model.dto.question.JudgeConfig;
import com.zj.xzOj.model.entity.Question;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
public class QuestionVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private String title;

    private String content;

    private List<String> tags;

    private Integer submitNum;

    private Integer acceptedNum;

    private JudgeConfig judgeConfig;

    private Integer thumbNum;

    private Integer favourNum;

    private Long userId;

    private Date createTime;

    private Date updateTime;

    private UserVO userVO;
    /**
     * 包装类转对象
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tags = questionVO.getTags();
        if(CollectionUtils.isEmpty(tags)){
            question.setTags(JSONUtil.toJsonStr(tags));
        }
        JudgeConfig voJudgeConfig = questionVO.getJudgeConfig();
        if(voJudgeConfig!=null){
            question.setJudgeConfig(JSONUtil.toJsonStr(voJudgeConfig));
        }
        return question;
    }

    /**
     * 对象转包装类
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        questionVO.setTags(JSONUtil.toList(question.getTags(), String.class));
        questionVO.setJudgeConfig(JSONUtil.toBean(question.getJudgeConfig(), JudgeConfig.class));
        return questionVO;
    }
}
