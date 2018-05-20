package vlib.entity;

import java.util.List;

public class ByClass extends JudgeData {
	
	public int id;
	public String className;	//类名
	public List<FieldData> fieldList;	//变量列表
	public List<MethodData> methodList;	//方法列表
	public JudgeDetail judgeDetail;
	
	public ByClass() {
		
	}
	public ByClass(String className, String classVisibility, boolean isStatic,
			List<FieldData> fieldList, List<MethodData> methodList) {
		super();
		this.className = className;
		this.fieldList = fieldList;
		this.methodList = methodList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
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
	public JudgeDetail getJudgeDetail() {
		return judgeDetail;
	}
	public void setJudgeDetail(JudgeDetail judgeDetail) {
		this.judgeDetail = judgeDetail;
	}
	
}
