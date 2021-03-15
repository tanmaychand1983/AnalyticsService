/**
 * {@summary}: This is the Service class for Ship Visit Modal Dialog.
 * @className: ShipVisitDetailsService
 * @author Deepak Bansal
 * @since: Mar 12, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 */
package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.ShipVisitDetailsEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.ShipVisitDetailsVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShipVisitDetailsService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = ShipVisitDetailsService.class.getName();
	
	public List<ShipVisitDetailsVO> getShipVisitDetails(String inspscheduledid){
		log.info(CLASS_NAME+"::Inside [getShipVisitDetails] Service method!");
		
		List<ShipVisitDetailsEntity> entityList = repository.getShipVisitDetails(
									QueryRepository.STORPROC_DASHBOARD_SHIPVISIT_DETAILS, 
									inspscheduledid);
		List<ShipVisitDetailsVO> shipVisitDetailsList =  new ArrayList<>();
		for(ShipVisitDetailsEntity entity: entityList) {
			ShipVisitDetailsVO shipVisitDetailsVO = new ShipVisitDetailsVO();
			
			shipVisitDetailsVO.setVesselName(entity.getVesselName());
			shipVisitDetailsVO.setVisitor(entity.getVisitor());
			shipVisitDetailsVO.setPortFrom(entity.getPortFrom());
			shipVisitDetailsVO.setPortTo(entity.getPortTo());
			shipVisitDetailsVO.setVisitType(entity.getVisitType());
			shipVisitDetailsVO.setDateIn(entity.getDateIn());
			shipVisitDetailsVO.setDateOut(entity.getDateOut());
			shipVisitDetailsVO.setVirDate(entity.getVirDate());
			shipVisitDetailsVO.setVisitDays(entity.getVisitDays());
			shipVisitDetailsVO.setNextDuedate(entity.getNextDuedate());
			shipVisitDetailsVO.setReviewDate(entity.getReviewDate());
			shipVisitDetailsVO.setVirSenttoowner(entity.getVirSenttoowner());
			shipVisitDetailsVO.setRemark(entity.getRemark());
			
			shipVisitDetailsList.add(shipVisitDetailsVO);
		}
		return shipVisitDetailsList;
	}
}
