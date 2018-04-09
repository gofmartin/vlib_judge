package vlib.entity;

public class ByInAndOut extends JudgeData {
	
	public String in;
	public String out;
	
	public ByInAndOut() {
		
	}
	public ByInAndOut(String in, String out) {
		this.in = in;
		this.out = out;
	}
	
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	
}
