package com.ssafy.dietboard.model.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dietboard.model.dto.Diet;
import com.ssafy.dietboard.util.DBUtil;

public class DietBoardRepositoryImpl implements DietBoardRepository {

	private DietBoardRepositoryImpl() {};
	private static DietBoardRepository repository = new DietBoardRepositoryImpl();
	
	public static DietBoardRepository getInstance() {
		return repository;
	}

	private DBUtil util = DBUtil.getInstance();
	
	@Override
	public List<Diet> selectAll() {
		List<Diet> list = new ArrayList<>();
		String sql = "SELECT * FROM diet";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Diet diet = new Diet();
				diet.setDietId(rs.getString("DietID"));
				diet.setDietMenu(rs.getString("DietMenu"));
				diet.setDietKcal(rs.getInt("DietKcal"));
				diet.setDietCarbs(rs.getDouble("DietCarbs"));
				diet.setDietProtein(rs.getDouble("DietProtein"));
				diet.setDietFat(rs.getDouble("DietFat"));
				list.add(diet);
			}
		} catch (Exception e) {
			
		} finally {
			util.close(rs, stmt, conn);
		}
		
		return list;
	}

}
