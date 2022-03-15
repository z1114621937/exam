package com.auths.domain;


import org.springframework.beans.factory.annotation.Value;

public class UmsMember {
    public UmsMember(Integer id, String username, String password,Integer status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status=status;
    }

    private Integer id;

    private Integer memberLevelId;


    private String username;

    private String password;

    private String nickname;


    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Integer memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
