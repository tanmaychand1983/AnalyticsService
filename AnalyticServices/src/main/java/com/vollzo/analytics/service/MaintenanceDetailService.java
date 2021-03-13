/**
 * {@summary}: This is the Service class for Maintenance Modal Dialog.
 * @className: MaintenanceDetailService
 * @author Deepak Bansal
 * @since: Mar 13, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 */
package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.MaintenanceDetailEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.MaintenanceDetailVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaintenanceDetailService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = MaintenanceDetailService.class.getName();
	
	public List<MaintenanceDetailVO> getMaintenanceDetails(String jobid){
		log.info(CLASS_NAME+"::Inside [getMaintenanceDetails] Service method!");
		
		List<MaintenanceDetailEntity> entityList = repository.getMaintenanceDetails(
				QueryRepository.STORPROC_DASHBOARD_MAINTENANCE_DETAILS, 
				jobid);
		List<MaintenanceDetailVO> maintenanceDetailList =  new ArrayList<>();
		for(MaintenanceDetailEntity entity: entityList) {
			MaintenanceDetailVO maintenanceDetailVO = new MaintenanceDetailVO();
			
			maintenanceDetailVO.setVesselName(entity.getVesselName());
			maintenanceDetailVO.setAge(entity.getAge());
			maintenanceDetailVO.setRankName(entity.getRankName());
			maintenanceDetailVO.setJobNumber(entity.getJobNumber());
			maintenanceDetailVO.setJobType(entity.getJobType());
			maintenanceDetailVO.setFrequency(entity.getFrequency());
			maintenanceDetailVO.setTitle(entity.getTitle());
			maintenanceDetailVO.setLastDone(entity.getLastDone());
			maintenanceDetailVO.setNextDue(entity.getNextDue());
			maintenanceDetailVO.setCritical(entity.getCritical());
			maintenanceDetailVO.setScheduledDate(entity.getScheduledDate());
			maintenanceDetailVO.setComponent(entity.getComponent());
			
			maintenanceDetailList.add(maintenanceDetailVO);
		}
		return maintenanceDetailList;
	}
}
