package com.vollzo.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vollzo.analytics.entity.BaseEntity;

/**
 * {@summary}: This is the Base Repository interface.
 * 
 * @className: BaseRepository
 * @author Ajaya Kar
 * @since: Jan 23, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */
@Repository
public interface BaseRepository extends JpaRepository<BaseEntity, Long>, AnalyticsRepository{
	
}
