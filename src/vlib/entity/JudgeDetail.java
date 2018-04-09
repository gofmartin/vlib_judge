package vlib.entity;

import java.util.List;

public class JudgeDetail {
	
	public String type;	//实验类型
	public String rule;	//判分方式
	public List<JudgeData> data;//判分数据列表
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public List<JudgeData> getData() {
		return data;
	}
	public void setData(List<JudgeData> data) {
		this.data = data;
	}
	
	
}
