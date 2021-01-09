package com.vollzo.nearMiss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vollzo.nearMiss.entity.NearMissEntity;

@Repository
public interface NearMissRepository extends JpaRepository<NearMissEntity, Long>{

	public static final String ALL_CATEGORY = "SELECT Id, category,subcategory,vesselid FROM rpt_nearmiss_test1 where vesselid is not null";
	//public static final String ALL_CATEGORY = "SELECT category, count(*) FROM rpt_nearmiss_test1 group by category";
	
	
	@Query(value = ALL_CATEGORY, nativeQuery = true)
	public List<NearMissEntity> getAllCategoryData();
	
}
