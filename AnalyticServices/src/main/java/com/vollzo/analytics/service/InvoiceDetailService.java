/**
 * {@summary}: This is the Service class for Invoice Modal Dialog.
 * @className: InvoiceDetailService
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

import com.vollzo.analytics.entity.InvoiceDetailEntity;
import com.vollzo.analytics.repository.BaseRepository;
import com.vollzo.analytics.repository.QueryRepository;
import com.vollzo.analytics.vo.InvoiceDetailVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InvoiceDetailService {

	@Autowired
	private BaseRepository repository;
	
	private static final String CLASS_NAME = InvoiceDetailService.class.getName();
	
	public List<InvoiceDetailVO> getInvoiceDetails(String poid){
		
		log.info(CLASS_NAME+"::Inside [getInvoiceDetails] Service method!");
		
		List<InvoiceDetailEntity> entityList = repository.getInvoiceDetails(
											QueryRepository.STORPROC_DASHBOARD_INVOICE_DETAILS, 
											poid);
		List<InvoiceDetailVO> invoiceDetailList =  new ArrayList<>();
		for(InvoiceDetailEntity entity: entityList) {
			InvoiceDetailVO invoiceDetailVO = new InvoiceDetailVO();
			invoiceDetailVO.setVesselName(entity.getVesselName());
			invoiceDetailVO.setVendorName(entity.getVendorName());
			invoiceDetailVO.setStatusName(entity.getStatusName());
			invoiceDetailVO.setRequisitionNumber(entity.getRequisitionNumber());
			invoiceDetailVO.setPoNumber(entity.getPoNumber());
			invoiceDetailVO.setSummary(entity.getSummary());
			invoiceDetailVO.setPoDate(entity.getPoDate());
			invoiceDetailVO.setPoTotalamount(entity.getPoTotalamount());
			invoiceDetailVO.setPoUsdamount(entity.getPoUsdamount());
			invoiceDetailVO.setInvoiceNumber(entity.getInvoiceNumber());
			invoiceDetailVO.setInvoiceAmount(entity.getInvoiceAmount());
			invoiceDetailVO.setNetPay(entity.getNetPay());
			invoiceDetailVO.setInvoiceDate(entity.getInvoiceDate());
			invoiceDetailVO.setPayDate(entity.getPayDate());
			invoiceDetailVO.setMaterialType(entity.getMaterialType());
			
			invoiceDetailList.add(invoiceDetailVO);
		}
		return invoiceDetailList;
	}
}
