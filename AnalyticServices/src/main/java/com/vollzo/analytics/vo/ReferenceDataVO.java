/**
 * {@summary}: This is the Reference Data VO for dashboard data.
 * @className: ReferenceDataVO
 * @author: Deepak Bansal
 * @since: Feb 01, 2021
 * @version: 1.0.0
 * 
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
public class ReferenceDataVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer id;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String refNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String reportedDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String reportedBy;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String requisitionNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String poNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String poDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String poTitle;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requisitionFor;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer accountCode;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String currencyTotalamount;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String usdTotalamount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String invoiceNo;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double invoiceAmount;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double netPay;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String portName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String stage;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String auditDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String dueDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String jobNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String jobType;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String frequency;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastDone;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String nextDue;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String critical;
	
	//For Port State Control Dashboard
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String inspectionId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String age;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String inspectionNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String inspectionDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mou;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String inspectorName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String inspectionStatus;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String deficiencieStatus;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String deficiencieCount;
	
	//Start: For Ship Visit
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String visitor;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String portFrom;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String dateIn;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String virDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String visitDays;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String nextDuedate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String virSenttoowner;
	
	public void setDateIn(String dateIn){
        this.dateIn = Util.dateFormat(dateIn,"yyyy-MM-dd");
    }
	
	public void setNextDuedate(String nextDuedate){
        this.nextDuedate = Util.dateFormat(nextDuedate,"yyyy-MM-dd");
    }
	
	public void setVirDate(String virDate){
        this.virDate = Util.dateFormat(virDate,"yyyy-MM-dd");
    }
	
	public void setPortFrom(String portFrom){
        this.portFrom = Util.stringFormat(portFrom);
    }
	
	//End: For Ship Visit
	
	//Start: For Fuel Consumption
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String speed;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String mainengineConsumption;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String auxilliaryengineConsumption;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String bolierConsumption;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String sea;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String activity;
	
	public void setSea(String sea){
        this.sea = Util.stringFormat(sea);
    }
	
	public void setActivity(String activity){
        this.activity = Util.stringFormat(portFrom);
    }
	
	//End: For Fuel Consumption
	
	public void setReportedDate(String reportedDate){
        this.reportedDate = Util.dateFormat(reportedDate,"yyyy-MM-dd");
    }
	
	public void setAuditDate(String auditDate){
        this.auditDate = Util.dateFormat(auditDate,"yyyy-MM-dd");
    }
	
	public void setDueDate(String dueDate){
        this.dueDate = Util.dateFormat(dueDate,"yyyy-MM-dd");
    }
	
	public void setNextDue(String nextDue){
        this.nextDue = Util.dateFormat(nextDue,"yyyy-MM-dd HH:mm:ss");
    }
	
	public void setLastDone(String lastDone){
        this.lastDone = Util.dateFormat(lastDone,"yyyy-MM-dd HH:mm:ss");
    }
	
	public void setInspectionDate(String inspectionDate){
        this.inspectionDate = Util.dateFormat(inspectionDate,"yyyy-MM-dd");
    }
	
	public void setPoDate(String poDate){
        this.poDate = Util.dateFormat(poDate,"yyyy-MM-dd");
    }
}
