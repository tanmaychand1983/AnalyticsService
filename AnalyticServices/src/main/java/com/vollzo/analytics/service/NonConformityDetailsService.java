/**
 * 
 * {@summary}: This is the Service class for Non Conformity details.
 * @className: NonConformityDetailsService
 * @author Deepak Bansal
 * @since: Feb 17, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.NonConformityDetailsEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.NonConformityDetailsVO;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NonConformityDetailsService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = NonConformityDetailsService.class.getName();
	
	
	public List<NonConformityDetailsVO> getNonConformityDetails(String auditncid){
		
		log.info(CLASS_NAME+"::Inside [getNonConformityDetails] Service method!");
		
		List<NonConformityDetailsEntity> entityList = repository.getNonConformityDetails(
				QueryRepository.STORPROC_DASHBOARD_NONCONF_DETAILS, 
				auditncid);
		List<NonConformityDetailsVO> nonConformityDetailsList =  new ArrayList<>();
		for(NonConformityDetailsEntity entity: entityList) {
			NonConformityDetailsVO nonConformityDetailsVO = new NonConformityDetailsVO();
			
			nonConformityDetailsVO.setDocumentReference(entity.getDocumentReference());
			nonConformityDetailsVO.setThetisCode(entity.getThetisCode());
			nonConformityDetailsVO.setDueDate(entity.getDueDate());
			nonConformityDetailsVO.setSummary(entity.getSummary());
			nonConformityDetailsVO.setImmediateAction(entity.getImmediateAction());
			nonConformityDetailsVO.setRootCause(entity.getRootCause());
			nonConformityDetailsVO.setCorrectiveAction(entity.getCorrectiveAction());
			nonConformityDetailsVO.setLongtermAction(entity.getLongtermAction());
			nonConformityDetailsVO.setCompletionDate(entity.getCompletionDate());
			nonConformityDetailsVO.setCloseoutDate(entity.getCloseoutDate());
			nonConformityDetailsVO.setCloseoutRemarks(entity.getCloseoutRemarks());
			
			nonConformityDetailsList.add(nonConformityDetailsVO);
		}
		return nonConformityDetailsList;
	}

}
