package vlib.dao;

import vlib.entity.JudgeDetail;

public interface RulesDao {
	public void add(JudgeDetail judgeDetail);
	public void edit(JudgeDetail judgeDetail);
	public JudgeDetail read(int expId);
}
