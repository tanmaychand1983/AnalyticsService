package com.vollzo.nearMiss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.nearMiss.entity.NearMissEntity;
import com.vollzo.nearMiss.repository.NearMissRepository;

@Service
public class NearMissService {

	
	@Autowired
	private NearMissRepository nearMissRepository;
	
	public List<NearMissEntity> getAllCategoryData(){
		return nearMissRepository.getAllCategoryData();
	}
	
}
