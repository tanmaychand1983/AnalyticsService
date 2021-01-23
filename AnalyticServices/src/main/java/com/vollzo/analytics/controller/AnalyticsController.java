package com.vollzo.analytics.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vollzo.analytics.entity.AccidentIncidentEntity;
import com.vollzo.analytics.entity.NearMissEntity;
import com.vollzo.analytics.entity.NonConformityEntity;
import com.vollzo.analytics.entity.PurchaseOrderEntity;
import com.vollzo.analytics.service.AnalyticsService;
import com.vollzo.analytics.vo.NearMissVO;
import com.vollzo.analytics.vo.UnitVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/analytics")
@CrossOrigin("*")
@Slf4j
public class AnalyticsController {

	@Autowired
	private AnalyticsService analyticsServices;
	
	private static final String CLASS_NAME = AnalyticsController.class.getName();
	
	@GetMapping(value ="/nearmiss", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NearMissVO> getNearMissData() {
		log.info(CLASS_NAME+"::Inside [getNearMissData] method!");
		return analyticsServices.getNearMissData();	
	}
	
	@GetMapping(value ="/accidentincident", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<AccidentIncidentEntity> getAccidentIncidentData() {
		log.info(CLASS_NAME+"::Inside [getAccidentIncidentData] method!");
		return analyticsServices.getAccidentIncidentData();	
	}
	
	@GetMapping(value ="/nonconformity", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<NonConformityEntity> getNonConformityData() {
		log.info(CLASS_NAME+"::Inside [getNonConformityData] method!");
		return analyticsServices.getNonConformityData();	
	}
	
	@GetMapping(value ="/purchaseorder", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PurchaseOrderEntity> getPurchaseOrderData() {
		log.info(CLASS_NAME+"::Inside [getPurchaseOrderData] method!");
		return analyticsServices.getPurchaseOrderData();	
	}
}
