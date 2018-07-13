package com.lhs.pension.dao;

import java.sql.SQLException;
import java.util.List;

import com.lhs.pension.dto.RentReserve;
import com.lhs.pension.dto.ReserveView;



public interface RentReserveIDao {
	public List<ReserveView> selectAllView(String key) throws SQLException;
	public int delete(int regno) throws SQLException;
	public RentReserve selectVO(int regno) throws SQLException;
	public int update(RentReserve dto) throws SQLException;
	public int insert(RentReserve dto) throws SQLException;
	public int getCurrval() throws SQLException;
	public RentReserve queryForObject(int regno);
	public void reserveCancel(int regno);
}
