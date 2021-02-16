/**
 * {@summary}: This is the Near Miss Details Data VO for modal dialog.
 * @className: NearMissDetailsVO
 * @author: Deepak Bansal
 * @since: Feb 11, 2021
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
public class NearMissDetailsVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String vesselName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String refNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String reportedDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String category;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String subcategory;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String latitude;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String longitude;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String portName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String immediateAction;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String rootCause;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String correctiveAction;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String preventiveAction;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String master;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String reportedBy;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String verificationInstruction;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String verificationDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String techsuprintendentName;
	
	public void setVesselName(String vesselName){
        this.vesselName = Util.stringFormat(vesselName);
    }
	public void setCategory(String category){
        this.category = Util.stringFormat(category);
    }
	public void setSubcategory(String subcategory){
        this.subcategory = Util.stringFormat(subcategory);
    }
	public void setMaster(String master){
        this.master = Util.stringFormat(master);
    }
	public void setReportedBy(String reportedBy){
        this.reportedBy = Util.stringFormat(reportedBy);
    }
	public void setTechsuprintendentName(String techsuprintendentName){
        this.techsuprintendentName = Util.stringFormat(techsuprintendentName);
    }
	public void setPortName(String portName){
        this.portName = Util.stringFormat(portName);
    }
}
