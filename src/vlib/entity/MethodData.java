package vlib.entity;

import java.util.List;

public class MethodData {
	
	public int id;
	public String methodName;	//方法名
	public String returnType;	//返回值类型
	public Object returnObject;	//期望返回值数据
	public List<ParamData> paramList;	//参数列表
	public ByClass byClass;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
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
	public ByClass getByClass() {
		return byClass;
	}
	public void setByClass(ByClass byClass) {
		this.byClass = byClass;
	}
	
}
