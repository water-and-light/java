package com.study.demo01.pojo;

public class College {
    @Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + "]";
	}

	private Integer collegeId;

    private String collegeName;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }
}