package com.vollzo.analytics.vo;
/**
 * {@summary}: This is the  Invoice Data VO for modal dialog.
 * @className: InvoiceDetailVO
 * @author: Deepak Bansal
 * @since: Mar 12, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 * 
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceDetailVO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String vesselName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String vendorName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String statusName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String requisitionNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String poNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String summary;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String poDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String poTotalamount;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String poUsdamount;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String invoiceNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String invoiceAmount;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String netPay;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String invoiceDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String payDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String materialType;
	
	
	public void setVesselName(String vesselName){
        this.vesselName = Util.stringFormat(vesselName);
    }
	
	public void setVendorName(String vendorName){
        this.vendorName = Util.stringFormat(vendorName);
    }
	
	public void setPoDate(String poDate){
        this.poDate = Util.dateFormat(poDate,"yyyy-MM-dd");
    }
	
	public void setInvoiceDate(String invoiceDate){
        this.invoiceDate = Util.dateFormat(invoiceDate,"yyyy-MM-dd");
    }
	
	public void setPayDate(String payDate){
        this.payDate = Util.dateFormat(payDate,"yyyy-MM-dd");
    }
}
