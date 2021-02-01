package com.vollzo.analytics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vollzo.analytics.entity.PurchaseOrderEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.AnalyticsRequestVO;
import com.vollzo.analytics.vo.AnalyticsResponseVO;
import com.vollzo.analytics.vo.BudgetCodeVO;
import com.vollzo.analytics.vo.MaterialTypeVO;
import com.vollzo.analytics.vo.ReferenceDataVO;
import com.vollzo.analytics.vo.StatusVO;
import com.vollzo.analytics.vo.UnitsVO;
import com.vollzo.analytics.vo.VendorVO;
import com.vollzo.analytics.vo.VesselVO;

/**
 * {@summary}: This is the Service class for PurchaseOrder module.
 * 
 * @className: PurchaseOrderService
 * @author Ajaya Kar
 * @since: Feb 1, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */

@Service
public class PurchaseOrderService {
	
	@Autowired
	private BaseRepository repository;
	
	/**
     * Returns Purchase Order Filter, Graph and Grid data by date range and vesselIds from Data layer.
     * 
     * @methodName: getPurchaseOrderData
     * @param: requestVO - AnalyticsRequestVO {Vessel Id List (Required), Start Date (defaultValue = ""), End Date (defaultValue = "")
     * @return - List<AnalyticsResponseVO>
     * 
     */
	public List<AnalyticsResponseVO> getPurchaseOrderData(AnalyticsRequestVO requestVO){
		List<PurchaseOrderEntity> entityList 		= 
				repository.getPurchaseOrderData(QueryRepository.STORPROC_DASHBOARD_PURORD, requestVO);
		
		Map<Integer, String> unitsMap = new HashMap<>();
		List<AnalyticsResponseVO> responseVOList = new ArrayList<>();
		List<VesselVO> vesselVOList = new ArrayList<VesselVO>();
		
		for (PurchaseOrderEntity entity : entityList) {
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
			ReferenceDataVO refVO 			= new ReferenceDataVO();			
			VesselVO vesselVO 				= new VesselVO();
			MaterialTypeVO materialTypeVO 	= new MaterialTypeVO();
			VendorVO vendorVO 				= new VendorVO();
			StatusVO statusVO 				= new StatusVO();
			BudgetCodeVO budgetCodeVO 		= new BudgetCodeVO();
			
			materialTypeVO.setMaterialType(entity.getMaterialType());
			vesselVO.setMaterialTypeVO(materialTypeVO);
			
			vendorVO.setVendorId(entity.getVendorId());
			vendorVO.setVendorDesc(entity.getVendorName());
			vesselVO.setVendorVO(vendorVO);
			
			statusVO.setStatusId(entity.getStatusId());
			statusVO.setStatusDesc(entity.getStatusName());
			vesselVO.setStatusVO(statusVO);
			
			budgetCodeVO.setBudgetCode(entity.getBudgetCode());
			vesselVO.setBudgetCodeVO(budgetCodeVO);
			
			refVO.setRequisitionNumber(entity.getRequisitionNumber());
			refVO.setPoNumber(entity.getPoNumber());
			refVO.setPoTitle(entity.getPoTitle());
			refVO.setAccountCode(entity.getBudgetCode());
			refVO.setTotalAmount(entity.getTotalAmount());
			refVO.setInvoiceNo(entity.getInvoiceNumber());
			refVO.setInvoiceAmount(entity.getInvoiceAmount());
			refVO.setNetPay(entity.getNetPay());
			vesselVO.setReferenceDataVO(refVO);
			
			vesselVO.setVesselId(entity.getVesselId());
			vesselVO.setVesselDesc(entity.getVesselName());
			
			vesselVOList.add(vesselVO);			
			unitsMap.get(unitId);
		}
		return responseVOList;
	}
}
