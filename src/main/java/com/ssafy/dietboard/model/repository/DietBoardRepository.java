package com.ssafy.dietboard.model.repository;

import java.util.List;

import com.ssafy.dietboard.model.dto.Diet;

public interface DietBoardRepository {

	List<Diet> selectAll();
	
	
}
