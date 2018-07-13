package com.lhs.pension.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lhs.pension.dto.PMember;


public interface PMemberIDao {
	public int insert(PMember dto) throws SQLException;
	public int delete(String key) throws SQLException;
	public int update(PMember dto) throws SQLException;
	public PMember select(String key) throws SQLException;
	public List<PMember> selectAll() throws SQLException;
	public List<PMember> find(Map<String,String> map) throws SQLException;
	public boolean close() throws SQLException;
	public String getPassWord(String id) throws SQLException;
	public int getAllCount() throws SQLException;
	public List<PMember> selectPart(int start, int end) throws SQLException;
	public int login(Map<String,String> map) throws SQLException;
}
