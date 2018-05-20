package vlib.entity;

import java.util.List;

public class JudgeDetail {
	
	public int id;
	public int expid;
	public String type;	//实验类型
	public String rule;	//判分方式
	public List<ByClass> data;//判分数据列表
	
	public int getExpid() {
		return expid;
	}
	public void setExpid(int expid) {
		this.expid = expid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public List<ByClass> getData() {
		return data;
	}
	public void setData(List<ByClass> data) {
		this.data = data;
	}
	
}
