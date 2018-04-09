package vlib.entity;

public class BySql extends JudgeData {
	
	public String sql;
	public String out;
	
	public BySql() {
		
	}
	public BySql(String sql, String out) {
		this.sql = sql;
		this.out = out;
	}
	
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	
}
