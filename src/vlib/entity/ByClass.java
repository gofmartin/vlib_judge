package vlib.entity;

public class ByClass extends JudgeData {
	
	public String className;
	public String classIn;
	public String classOut;
	
	public ByClass() {
		
	}
	
	public ByClass(String className, String classIn, String classOut) {
		this.className = className;
		this.classIn = classIn;
		this.classOut = classOut;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassIn() {
		return classIn;
	}
	public void setClassIn(String classIn) {
		this.classIn = classIn;
	}
	public String getClassOut() {
		return classOut;
	}
	public void setClassOut(String classOut) {
		this.classOut = classOut;
	}
	
}
