package vlib.core;

import vlib.entity.JudgeResult;

public interface AdvancedJudger {
	public JudgeResult judgeCProj(String projurl, int expid);
	public JudgeResult judgeJavaProj(String projurl, int expid);
	public JudgeResult judgeCSProj(String projurl, int expid);
	public JudgeResult judgeDBProj(String projurl, int expid);
}
