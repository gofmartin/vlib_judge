package vlib.entity;

public class ByLog extends JudgeData {
	
	public String opName;
	public String opDetail;
	
	public ByLog() {
		
	}
	public ByLog(String opName, String opDetail) {
		this.opName = opName;
		this.opDetail = opDetail;
	}
	
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public String getOpDetail() {
		return opDetail;
	}
	public void setOpDetail(String opDetail) {
		this.opDetail = opDetail;
	}
	
}
