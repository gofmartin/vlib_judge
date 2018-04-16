package vlib.entity;

import java.util.List;

public class MethodData {
	
	public String visibility;	//可见性
	public String returnType;	//返回值类型
	public Object returnObject;	//返回值数据
	public List<ParamData> paramList;	//参数列表
	
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public Object getReturnObject() {
		return returnObject;
	}
	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}
	public List<ParamData> getParamList() {
		return paramList;
	}
	public void setParamList(List<ParamData> paramList) {
		this.paramList = paramList;
	}
	
}
