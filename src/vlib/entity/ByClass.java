package vlib.entity;

import java.util.List;

public class ByClass extends JudgeData {
	
	public String className;	//类名
	public String classField;	//可见性
	public boolean isStatic;	//是否静态
	public List<FieldData> fieldList;	//变量列表
	public List<MethodData> methodList;	//方法列表
	
	public ByClass() {
		
	}
	
	public ByClass(String className, String classField) {
		this.className = className;
		this.classField = classField;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getClassField() {
		return classField;
	}

	public void setClassField(String classField) {
		this.classField = classField;
	}
	
}
