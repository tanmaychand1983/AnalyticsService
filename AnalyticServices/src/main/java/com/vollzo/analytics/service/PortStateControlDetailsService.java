/**
 * 
 * {@summary}: This is the Service class for Port State Control details.
 * @className: PortStateControlDetailsService
 * @author Deepak Bansal
 * @since: Feb 17, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.PortStateControlDetailsEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.DeficienciesVO;
import com.vollzo.analytics.vo.InspectionVO;
import com.vollzo.analytics.vo.PortStateControlDetailsVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PortStateControlDetailsService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = PortStateControlDetailsService.class.getName();
	
	public List<PortStateControlDetailsVO> getPortStateControlDetails(String inspectionid){
		
		log.info(CLASS_NAME+"::Inside [getPortStateControlDetails] Service method!");
		
		List<PortStateControlDetailsEntity> entitylist = repository.getPortStateControlDetails(
							QueryRepository.STORPROC_DASHBOARD_INSPECTION_DETAILS, inspectionid);
		Map<String, String> inspectionMap 	= new HashMap<>();
		
		List<PortStateControlDetailsVO> portStateControlDetailsList = new ArrayList<>();
		
		List<DeficienciesVO> deficienciesVOList = new ArrayList<DeficienciesVO>();
		
		for(PortStateControlDetailsEntity entity: entitylist) {
			String inspectionNumber = entity.getInspectionNumber();
			
			PortStateControlDetailsVO portStateControlDetailsVO = new PortStateControlDetailsVO();
			
			if(!inspectionMap.containsKey(inspectionNumber)) {
				InspectionVO inspectionVO = new InspectionVO();
				deficienciesVOList = new ArrayList<DeficienciesVO>();
				
				inspectionMap.put(inspectionNumber, new String());
				
				inspectionVO.setInspectionNumber(inspectionNumber);
				inspectionVO.setInspectionDate(entity.getInspectionDate());
				inspectionVO.setPortName(entity.getPortName());
				inspectionVO.setMou(entity.getMou());
				inspectionVO.setOtherMou(entity.getOtherMou());
				inspectionVO.setMasterName(entity.getMasterName());
				inspectionVO.setChiefengineerName(entity.getChiefengineerName());
				
				inspectionVO.setDeficienciesVO(deficienciesVOList);
				
				portStateControlDetailsVO.setInspectionVO(inspectionVO);
				portStateControlDetailsList.add(portStateControlDetailsVO);
			}else {
				
			}
			DeficienciesVO deficienciesVO = new DeficienciesVO();
			deficienciesVO.setDueDate(entity.getDueDate());
			deficienciesVO.setNatureofDeficiency(entity.getNatureofDeficiency());
			deficienciesVOList.add(deficienciesVO);

			inspectionMap.get(inspectionNumber);
		}
		
		return portStateControlDetailsList;
	}
	
}
