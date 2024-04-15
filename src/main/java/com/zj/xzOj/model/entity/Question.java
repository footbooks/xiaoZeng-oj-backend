package com.zj.xzOj.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 题目
 * </p>
 *
 * @author zengjing
 * @since 2024-04-14
 */
@ApiModel(value = "Question对象", description = "题目")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("标签列表（json 数组）")
    private String tags;

    @ApiModelProperty("题目答案")
    private String answer;

    @ApiModelProperty("题目提交数")
    private Integer submitNum;

    @ApiModelProperty("题目通过数")
    private Integer acceptedNum;

    @ApiModelProperty("判题用例（json 数组）")
    private String judgeCase;

    @ApiModelProperty("判题配置（json 对象）")
    private String judgeConfig;

    @ApiModelProperty("点赞数")
    private Integer thumbNum;

    @ApiModelProperty("收藏数")
    private Integer favourNum;

    @ApiModelProperty("创建用户 id")
    private Long userId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除")
    @TableLogic
    private Integer isDelete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getSubmitNum() {
        return submitNum;
    }

    public void setSubmitNum(Integer submitNum) {
        this.submitNum = submitNum;
    }

    public Integer getAcceptedNum() {
        return acceptedNum;
    }

    public void setAcceptedNum(Integer acceptedNum) {
        this.acceptedNum = acceptedNum;
    }

    public String getJudgeCase() {
        return judgeCase;
    }

    public void setJudgeCase(String judgeCase) {
        this.judgeCase = judgeCase;
    }

    public String getJudgeConfig() {
        return judgeConfig;
    }

    public void setJudgeConfig(String judgeConfig) {
        this.judgeConfig = judgeConfig;
    }

    public Integer getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(Integer thumbNum) {
        this.thumbNum = thumbNum;
    }

    public Integer getFavourNum() {
        return favourNum;
    }

    public void setFavourNum(Integer favourNum) {
        this.favourNum = favourNum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Question{" +
        "id=" + id +
        ", title=" + title +
        ", content=" + content +
        ", tags=" + tags +
        ", answer=" + answer +
        ", submitNum=" + submitNum +
        ", acceptedNum=" + acceptedNum +
        ", judgeCase=" + judgeCase +
        ", judgeConfig=" + judgeConfig +
        ", thumbNum=" + thumbNum +
        ", favourNum=" + favourNum +
        ", userId=" + userId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        "}";
    }
}
