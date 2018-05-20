package vlib.entity;

public class FieldData {
	
	public int id;
	public String type;			//变量类型
	public String name;			//变量名
	public ByClass byClass;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ByClass getByClass() {
		return byClass;
	}
	public void setByClass(ByClass byClass) {
		this.byClass = byClass;
	}
	
}
