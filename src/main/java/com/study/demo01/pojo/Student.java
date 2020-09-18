package com.study.demo01.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "handler" })
public class Student {
    private Integer stuId;

    private String stuNo;

    private String stuName;

    private String stuLogin;

    private String stuPasswd;

    private String stuPhone;

    private Integer stuLimit;

    private Integer stuRemain;

    private String stuNote;

    private Integer collegeId;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuLogin() {
        return stuLogin;
    }

    public void setStuLogin(String stuLogin) {
        this.stuLogin = stuLogin == null ? null : stuLogin.trim();
    }

    public String getStuPasswd() {
        return stuPasswd;
    }

    public void setStuPasswd(String stuPasswd) {
        this.stuPasswd = stuPasswd == null ? null : stuPasswd.trim();
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public Integer getStuLimit() {
        return stuLimit;
    }

    public void setStuLimit(Integer stuLimit) {
        this.stuLimit = stuLimit;
    }

    public Integer getStuRemain() {
        return stuRemain;
    }

    public void setStuRemain(Integer stuRemain) {
        this.stuRemain = stuRemain;
    }

    public String getStuNote() {
        return stuNote;
    }

    public void setStuNote(String stuNote) {
        this.stuNote = stuNote == null ? null : stuNote.trim();
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuNo=" + stuNo + ", stuName=" + stuName + ", stuLogin=" + stuLogin
				+ ", stuPasswd=" + stuPasswd + ", stuPhone=" + stuPhone + ", stuLimit=" + stuLimit + ", stuRemain="
				+ stuRemain + ", stuNote=" + stuNote + ", collegeId=" + collegeId + "]";
	}
    
}