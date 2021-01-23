package com.vollzo.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vollzo.analytics.entity.BaseEntity;

@Repository
public interface BaseRepository extends JpaRepository<BaseEntity, Long>, AnalyticsRepository{
	
}
