package com.zj.xzOj.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author zengjing
 * @since 2024-04-14
 */
@ApiModel(value = "User对象", description = "用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("账号")
    private String userAccount;

    @ApiModelProperty("密码")
    private String userPassword;

    @ApiModelProperty("微信开放平台id")
    private String unionId;

    @ApiModelProperty("公众号openId")
    private String mpOpenId;

    @ApiModelProperty("用户昵称")
    private String userName;

    @ApiModelProperty("用户头像")
    private String userAvatar;

    @ApiModelProperty("用户简介")
    private String userProfile;

    @ApiModelProperty("用户角色：user/admin/ban")
    private String userRole;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除")
    private Integer isDelete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getMpOpenId() {
        return mpOpenId;
    }

    public void setMpOpenId(String mpOpenId) {
        this.mpOpenId = mpOpenId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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
        return "User{" +
        "id=" + id +
        ", userAccount=" + userAccount +
        ", userPassword=" + userPassword +
        ", unionId=" + unionId +
        ", mpOpenId=" + mpOpenId +
        ", userName=" + userName +
        ", userAvatar=" + userAvatar +
        ", userProfile=" + userProfile +
        ", userRole=" + userRole +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        "}";
    }
}
