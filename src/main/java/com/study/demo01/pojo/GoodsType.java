package com.study.demo01.pojo;

public class GoodsType {
    private Integer typeId;

    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

	public String toString() {
		return "GoodsType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
    
}