package vlib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vlib.dao.RulesDao;
import vlib.util.DBUtils;

public class RulesDaoImpl implements RulesDao {

	@Override
	public void add(int expId, String rule) {
		Connection con = DBUtils.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "insert into vlibrules(expid,rule) values(?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, expId);
			pstmt.setString(2, rule);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, con);
		}
	}

	@Override
	public void edit(int expId, String rule) {
		Connection con = DBUtils.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "update rules set rule=? where expid=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rule);
			pstmt.setInt(2, expId);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, con);
		}
	}

	@Override
	public String read(int expId) {
		Connection con = DBUtils.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "";
		
		String sql = "select * from rules where expid=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, expId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("rule");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, pstmt, con);
		}
		
		return result;
	}

}
