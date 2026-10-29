package com.ssafy.dietboard.service;

import java.util.List;

import com.ssafy.dietboard.model.dto.Diet;
import com.ssafy.dietboard.model.repository.DietBoardRepository;
import com.ssafy.dietboard.model.repository.DietBoardRepositoryImpl;

public class DietBoardServiceImpl implements DietBoardService {
	
	//싱글턴
	private DietBoardServiceImpl() {}
	private static DietBoardService service = new DietBoardServiceImpl();
	public static DietBoardService getInstance() {
		return service;
	}
	//
	
	private DietBoardRepository repository = DietBoardRepositoryImpl.getInstance();
	
	@Override
	public List<Diet> getList() {
		return repository.selectAll();
	}
	
	
}
