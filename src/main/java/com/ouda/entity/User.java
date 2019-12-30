package com.ouda.entity;


public class User {
    private Integer id;
    private String name;
    private String nickName;
    private String avatar;
    private String sign;
    private String remark;
    private Integer isGroupChat;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setIsGroupChat(Integer isGroupChat) {
        this.isGroupChat = isGroupChat;
    }

    public Integer getIsGroupChat() {
        return isGroupChat;
    }
}