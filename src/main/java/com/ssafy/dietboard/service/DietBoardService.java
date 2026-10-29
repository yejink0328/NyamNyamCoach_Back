package com.ssafy.dietboard.service;

import java.util.List;

import com.ssafy.dietboard.model.dto.Diet;

public interface DietBoardService {

	//전체 식단 목록
	List<Diet> getList();

}
