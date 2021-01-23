package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.entity.PurchaseOrderEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.CategoryVO;
import com.vollzo.analytics.vo.DataVO;
import com.vollzo.analytics.vo.NearMissVO;
import com.vollzo.analytics.vo.StatusVO;
import com.vollzo.analytics.vo.UnitVO;
import com.vollzo.analytics.vo.VesselVO;

@Service
public class AnalyticsService {

	@Autowired
	private BaseRepository nearMissRepository;
	
	public List<NearMissVO> getNearMissData(){
		List<NearMissVO> nearMissDataList = new ArrayList<>();
		List<NearMissEntity> nearMissEntityList = nearMissRepository.getNeaMissData(QueryRepository.STORPROC_DASHBOARD_NEARMISS);
		
		
		//nearMissDataMap = nearMissEntityList.stream()
				  //.collect(Collectors.groupingBy(NearMissEntity :: getUnitId));

		List<DataVO> dataVOList = new ArrayList<>();
		List<UnitVO> unitVOList = new ArrayList<>();
		List<StatusVO> statusVOList = new ArrayList<>();
		List<CategoryVO> categoryVOList = new ArrayList<>();
		List<VesselVO> vesselVOList = new ArrayList<>();
		for(NearMissEntity nearMissEntity :  nearMissEntityList) {
			UnitVO unitVO = new UnitVO(); 
			CategoryVO categoryVO = new CategoryVO();;
			VesselVO vesselVO = new VesselVO();
			StatusVO statusVO = new StatusVO();
			DataVO dataVO = new DataVO();
			
			if(unitVOList.stream()
				     .filter(item -> item.getUnitId() == nearMissEntity.getUnitId()).collect(Collectors.toList()).size() < 1) {
			  System.out.println("getCategoryId check");
			  unitVO.setUnitId(nearMissEntity.getUnitId());
			  unitVO.setUnitName(nearMissEntity.getUnitName());
			  unitVOList.add(unitVO);
			}
			if(vesselVOList.stream()
					.filter(item -> item.getVesselId() == nearMissEntity.getVesselId()).collect(Collectors.toList()).size() < 1) {
				System.out.println("getVesselId check");
				vesselVO.setVesselId(nearMissEntity.getVesselId());
				vesselVO.setVesselName(nearMissEntity.getVesselName());
				vesselVO.setUnitId(nearMissEntity.getUnitId());
				vesselVOList.add(vesselVO);
			}
			if(categoryVOList.stream()
				     .filter(item -> item.getCategoryId() == nearMissEntity.getCategoryId()).collect(Collectors.toList()).size() < 1) {
				System.out.println("getVesselId check");
				categoryVO.setCategoryId(nearMissEntity.getCategoryId());
				categoryVO.setCategoryName(nearMissEntity.getCategoryName());
				categoryVO.setUnitId(nearMissEntity.getUnitId());
				categoryVOList.add(categoryVO);
			}
			if(statusVOList.stream()
				     .filter(item -> item.getStatusId() == nearMissEntity.getStatusId()).collect(Collectors.toList()).size() < 1) {
				System.out.println("getStatusId check");
				statusVO.setStatusId(nearMissEntity.getStatusId());
				statusVO.setStatusName(nearMissEntity.getStatusName());
				statusVO.setUnitId(nearMissEntity.getUnitId());
				statusVOList.add(statusVO);
			}
			dataVO.setCategoryId(nearMissEntity.getCategoryId());
			dataVO.setRefNumber(nearMissEntity.getRefNumber());
			dataVO.setReportedBy(nearMissEntity.getReportedBy());
			dataVO.setReportedDate(nearMissEntity.getReportedDate());
			dataVO.setStatusId(nearMissEntity.getStatusId());
			dataVO.setTitle(nearMissEntity.getTitle());
			dataVO.setVesselId(nearMissEntity.getVesselId());
			dataVO.setUnitId(nearMissEntity.getUnitId());
			dataVOList.add(dataVO);
		}
		NearMissVO nearMissVO = new NearMissVO();
		nearMissVO.setCategoryList(categoryVOList);
		nearMissVO.setUnitList(unitVOList);
		nearMissVO.setVesselList(vesselVOList);
		nearMissVO.setStatusList(statusVOList);
		nearMissVO.setDataList(dataVOList);
		nearMissDataList.add(nearMissVO);
		return nearMissDataList;
	}
	
	public List<AccidentIncidentEntity> getAccidentIncidentData(){
		return nearMissRepository.getAccidentIncidentData(QueryRepository.STORPROC_DASHBOARD_ACCINC);
	}
	
	public List<NonConformityEntity> getNonConformityData(){
		return nearMissRepository.getNonConformityData(QueryRepository.STORPROC_DASHBOARD_NONCONF);
	}
	
	public List<PurchaseOrderEntity> getPurchaseOrderData(){
		return nearMissRepository.getPurchaseOrderData(QueryRepository.STORPROC_DASHBOARD_PURORD);
	}
}
