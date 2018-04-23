package vlib.entity;

public class JudgeResult {
	
	public int score;
	public int totalScore;
	public String judgeDetail = "";

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public String getJudgeDetail() {
		return judgeDetail;
	}
	public void addJudgeDetail(String str) {
		judgeDetail += (str + "\n");
	}
	public void setJudgeDetail(String judgeDetail) {
		this.judgeDetail = judgeDetail;
	}
	
}
