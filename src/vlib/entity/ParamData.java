package vlib.entity;

public class ParamData {
	
	public int id;
	public String type;
	public Object testData;
	public MethodData methodData;
	
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
	public Object getTestData() {
		return testData;
	}
	public void setTestData(Object testData) {
		this.testData = testData;
	}
	public MethodData getMethodData() {
		return methodData;
	}
	public void setMethodData(MethodData methodData) {
		this.methodData = methodData;
	}
	
}
