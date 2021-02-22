/**
 * {@summary}: This is the Purchase Order Data VO for modal dialog.
 * @className: PurchaseOrderVO
 * @author: Deepak Bansal
 * @since: Feb 16, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseOrderDetailsVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String poNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String statusName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String vesselName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String vendorName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String poType;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String category;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String summary;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String poDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String expectedReadinessDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String poAmount;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String poAmountUSD;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String accountCode;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String requisitionNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String expectedDeliveryTime;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String billingAddress;
	
	public void setVesselName(String vesselName){
        this.vesselName = Util.stringFormat(vesselName);
    }
	
	public void setStatusName(String statusName){
        this.statusName = Util.stringFormat(statusName);
    }
	
	public void setVendorName(String vendorName){
        this.vendorName = Util.stringFormat(vendorName);
    }
	
	public void setCategory(String category){
        this.category = Util.stringFormat(category);
    }
	
	public void setPoType(String poType){
        this.poType = Util.stringFormat(poType);
    }
	
	public void setPoDate(String poDate){
        this.poDate = Util.dateFormat(poDate,"yyyy-MM-dd");
    }
	
	public void setExpectedReadinessDate(String expectedReadinessDate){
        this.expectedReadinessDate = Util.dateFormat(expectedReadinessDate,"yyyy-MM-dd");
    }
}
