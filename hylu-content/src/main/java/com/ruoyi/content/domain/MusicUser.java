package com.ruoyi.content.domain;

import com.ruoyi.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户表 music_user
 *
 * @author hylu
 * @date 2018-11-30
 */
public class MusicUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;
    /**
     * 用户编码
     */
    private String userId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 备注名称
     */
    private String remarkName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 名称拼音
     */
    private String py;
    /**
     * 性别 0未知 1男 2女
     */
    private Integer gender;
    /**
     * 动态数
     */
    private Integer eventCount;
    /**
     * 关注数
     */
    private Integer followCount;
    /**
     * 粉丝数
     */
    private Integer fanCount;
    /**
     * 个人签名
     */
    private String signature;
    /**
     * 歌手类型
     */
    private Integer authStatus;
    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 状态：1已使用 0未使用
     */
    private Integer hasUsed;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getPy() {
        return py;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getGender() {
        return gender;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFanCount(Integer fanCount) {
        this.fanCount = fanCount;
    }

    public Integer getFanCount() {
        return fanCount;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserType() {
        return userType;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("nickname", getNickname())
                .append("remarkName", getRemarkName())
                .append("avatar", getAvatar())
                .append("py", getPy())
                .append("gender", getGender())
                .append("eventCount", getEventCount())
                .append("followCount", getFollowCount())
                .append("fanCount", getFanCount())
                .append("signature", getSignature())
                .append("authStatus", getAuthStatus())
                .append("userType", getUserType())
                .append("hasUsed", getHasUsed())
                .toString();
    }

    public Integer getHasUsed() {
        return hasUsed;
    }

    public void setHasUsed(Integer hasUsed) {
        this.hasUsed = hasUsed;
    }
}
