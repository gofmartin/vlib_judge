package vlib.dao;

public interface RulesDao {
	public void add(int expId, String rule);
	public void edit(int expId, String rule);
	public String read(int expId);
}
