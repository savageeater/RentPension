package com.lhs.pension.dao;

import java.sql.SQLException;
import java.util.List;

import com.lhs.pension.dto.RentPension;

public interface RentPensionIDao<T,K> {

	public boolean isExist(K key) throws SQLException;//��

	public boolean insert(RentPension dto) throws SQLException;//��

	public int delete(K key) throws SQLException;//��

	public int update(RentPension dto) 
			throws SQLException;
	public List<T> queryForList() throws SQLException;
	public List<T> queryForList(K key) throws SQLException;

	public T queryForObject(K key) throws SQLException;
	public int getAllCount() throws SQLException;
	public int getMaxNo()  throws SQLException;
	public List<T> selectPart(int start,int end)  
			throws SQLException;
	public int getCurrval() throws SQLException;

	public List<RentPension> selectAll() throws SQLException;
	
	public int allcount() throws SQLException;
	
	public RentPension selectVo(int no) throws SQLException;
	
	public List<RentPension> selectKey(int category) throws SQLException;
}
