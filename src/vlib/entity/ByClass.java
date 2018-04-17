package vlib.entity;

import java.util.List;

public class ByClass extends JudgeData {
	
	public String className;	//类名
	public String classVisibility;	//可见性
	public List<FieldData> fieldList;	//变量列表
	public List<MethodData> methodList;	//方法列表
	
	public ByClass() {
		
	}
	public ByClass(String className, String classVisibility, boolean isStatic,
			List<FieldData> fieldList, List<MethodData> methodList) {
		super();
		this.className = className;
		this.classVisibility = classVisibility;
		this.fieldList = fieldList;
		this.methodList = methodList;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassVisibility() {
		return classVisibility;
	}
	public void setClassVisibility(String classVisibility) {
		this.classVisibility = classVisibility;
	}
	public List<FieldData> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<FieldData> fieldList) {
		this.fieldList = fieldList;
	}
	public List<MethodData> getMethodList() {
		return methodList;
	}
	public void setMethodList(List<MethodData> methodList) {
		this.methodList = methodList;
	}
	
}
