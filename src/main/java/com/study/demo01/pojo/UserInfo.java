package com.study.demo01.pojo;

public class UserInfo {
    private Integer userId;

    private String userName;

    private String userLogin;

    private String userPasswd;

    @Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userLogin=" + userLogin + ", userPasswd="
				+ userPasswd + "]";
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin == null ? null : userLogin.trim();
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd == null ? null : userPasswd.trim();
    }
}