/**
 * {@summary}: This is the Service class for Fuel Consumption Dashboard.
 * @className: FuelConsumptionService
 * @author Deepak Bansal
 * @since: Mar 15, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 */
package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.FuelConsumptionEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.LoadingConditionVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VesselVO;
import com.vollzo.analytics.vo.WeatherVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FuelConsumptionService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = FuelConsumptionService.class.getName();
	
	public List<AnalyticsResponseVO> getFuelConsumptionData(AnalyticsRequestVO requestVO){
		log.info(CLASS_NAME+"::Inside [getFuelConsumptionData] Service method!");
		
		List<FuelConsumptionEntity> entityList = repository.getFuelConsumptionData(
				QueryRepository.STORPROC_DASHBOARD_FUELCONSUMPTION, requestVO);
		Map<Integer, String> unitsMap = new HashMap<>();
		List<AnalyticsResponseVO> responseVOList = new ArrayList<>();
		List<VesselVO> vesselVOList = new ArrayList<VesselVO>();
		for(FuelConsumptionEntity entity : entityList) {
			int unitId = entity.getUnitId();
			String unitName = entity.getUnitName();				 
			AnalyticsResponseVO responseVO = new AnalyticsResponseVO();
			if(!unitsMap.containsKey(unitId)) {
				UnitsVO unitVO = new UnitsVO();
				vesselVOList = new ArrayList<VesselVO>();
				unitsMap.put(unitId, new String());
				unitVO.setUnitId(unitId);
				unitVO.setUnitDesc(unitName);
				unitVO.setVesselVO(vesselVOList);
				responseVO.setUnitsVO(unitVO);
				responseVOList.add(responseVO);
			}
			ReferenceDataVO referenceDataVO 	= new ReferenceDataVO();			
			VesselVO vesselVO 					= new VesselVO();
			LoadingConditionVO loadingConditionVO = new LoadingConditionVO();
			WeatherVO weatherVO					= new WeatherVO();
			
			loadingConditionVO.setConditions(entity.getConditions());
			weatherVO.setWeather(entity.getWeather());
			referenceDataVO.setId(entity.getId());
			referenceDataVO.setSpeed(entity.getSpeed());
			referenceDataVO.setMainengineConsumption(entity.getMainengineConsumption());
			referenceDataVO.setAuxilliaryengineConsumption(entity.getAuxilliaryengineConsumption());
			referenceDataVO.setBolierConsumption(entity.getBolierConsumption());
			referenceDataVO.setSea(entity.getSea());
			referenceDataVO.setActivity(entity.getActivity());
			referenceDataVO.setReportedDate(entity.getReportDate());
			
			vesselVO.setVesselId(entity.getVesselId());
			vesselVO.setVesselDesc(entity.getVesselName());
			vesselVO.setLoadingConditionVO(loadingConditionVO);
			vesselVO.setWeatherVO(weatherVO);
			vesselVO.setReferenceDataVO(referenceDataVO);
			
			vesselVOList.add(vesselVO);
			unitsMap.get(unitId);
		}
		
		return responseVOList;
	}
}
