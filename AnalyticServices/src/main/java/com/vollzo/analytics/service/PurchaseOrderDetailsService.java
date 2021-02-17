/**
 * 
 * {@summary}: This is the Service class for Purchase Order details.
 * @className: PurchaseOrderDetailsService
 * @author Deepak Bansal
 * @since: Feb 16, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vollzo.analytics.entity.PurchaseOrderDetailsEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.PurchaseOrderDetailsVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PurchaseOrderDetailsService {
	
	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = PurchaseOrderDetailsService.class.getName();
	
	public List<PurchaseOrderDetailsVO> getPurchaseOrderDetails(String poId){
		log.info(CLASS_NAME+"::Inside [getPurchaseOrderDetails] Service method!");
		List<PurchaseOrderDetailsEntity> entityList = repository.getPurchaseOrderDetails(
				QueryRepository.STORPROC_DASHBOARD_PO_DETAILS, 
				poId);
		List<PurchaseOrderDetailsVO> purchaseOrderDetailslist =  new ArrayList<>();
		
		for(PurchaseOrderDetailsEntity entity: entityList) {
			
			PurchaseOrderDetailsVO purchaseOrderVO = new PurchaseOrderDetailsVO();
			purchaseOrderVO.setPoNumber(entity.getPoNumber());
			purchaseOrderVO.setStatusName(entity.getStatusName());
			purchaseOrderVO.setVesselName(entity.getVesselName());
			purchaseOrderVO.setVendorName(entity.getVendorName());
			purchaseOrderVO.setPoType(entity.getPoType());
			purchaseOrderVO.setCategory(entity.getCategory());
			purchaseOrderVO.setSummary(entity.getSummary());
			purchaseOrderVO.setPoDate(entity.getPoDate());
			purchaseOrderVO.setExpectedReadinessDate(entity.getExpectedReadinessDate());
			purchaseOrderVO.setPoAmount(entity.getPoAmount());
			purchaseOrderVO.setPoAmountUSD(entity.getPoAmountUSD());
			purchaseOrderVO.setAccountCode(entity.getAccountCode());
			purchaseOrderVO.setRequisitionNumber(entity.getRequisitionNumber());
			purchaseOrderVO.setExpectedDeliveryTime(entity.getExpectedDeliveryTime());
			purchaseOrderVO.setBillingAddress(entity.getBillingAddress());
			
			purchaseOrderDetailslist.add(purchaseOrderVO);
		}
		return purchaseOrderDetailslist;
	}
}
