/**
 * 
 * {@summary}: This is the Service class for NearMiss details.
 * @className: NearMissDetailsService
 * @author Deepak Bansal
 * @since: Feb 11, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.service;

import java.util.ArrayList;
import com.vollzo.analytics.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.NearMissDetailsEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.NearMissDetailsVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NearMissDetailsService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = NearMissDetailsService.class.getName();
	
	public List<NearMissDetailsVO> getNearMissDetails(String nearmissId){
		log.info(CLASS_NAME+"::Inside [getNearMissDetails] Serive method!");
		List<NearMissDetailsEntity> entityList = repository.getNearMissDetails(
							QueryRepository.STORPROC_DASHBOARD_NEARMISS_DETAILS, 
							nearmissId);
		List<NearMissDetailsVO> nearMissDetailslist =  new ArrayList<>();

		for(NearMissDetailsEntity entity: entityList) {
			NearMissDetailsVO nearMissDetailsVO = new NearMissDetailsVO();
			nearMissDetailsVO.setVesselName(Util.stringFormat(entity.getVesselName()));
			nearMissDetailsVO.setRefNumber(entity.getRefNumber());
			nearMissDetailsVO.setReportedDate(entity.getReportedDate());
			nearMissDetailsVO.setType(entity.getType());
			nearMissDetailsVO.setCategory(Util.stringFormat(entity.getCategory()));
			nearMissDetailsVO.setSubcategory(Util.stringFormat(entity.getSubcategory()));
			nearMissDetailsVO.setLatitude(entity.getLatitude());
			nearMissDetailsVO.setLongitude(entity.getLongitude());
			nearMissDetailsVO.setPortName(Util.stringFormat(entity.getPortName()));
			nearMissDetailsVO.setDescription(entity.getDescription());
			nearMissDetailsVO.setImmediateAction(entity.getImmediateAction());
			nearMissDetailsVO.setRootCause(entity.getRootCause());
			nearMissDetailsVO.setCorrectiveAction(entity.getCorrectiveAction());
			nearMissDetailsVO.setPreventiveAction(entity.getPreventiveAction());
			nearMissDetailsVO.setCreatedDate(entity.getCreatedDate());
			nearMissDetailsVO.setMaster(Util.stringFormat(entity.getMaster()));
			nearMissDetailsVO.setReportedBy(entity.getReportedBy());
			nearMissDetailsVO.setVerificationInstruction(entity.getVerificationInstruction());
			nearMissDetailsVO.setVerificationDate(entity.getVerificationDate());
			nearMissDetailsVO.setTechsuprintendentName(Util.stringFormat(entity.getTechsuprintendentName()));
			
			nearMissDetailslist.add(nearMissDetailsVO);
		}
		
		return nearMissDetailslist;
	}
}
