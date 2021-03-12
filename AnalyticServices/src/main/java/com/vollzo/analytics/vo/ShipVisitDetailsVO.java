/**
 * {@summary}: This is the  Ship Visit Data VO for modal dialog.
 * @className: ShipVisitDetailsVO
 * @author: Deepak Bansal
 * @since: Mar 12, 2021
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
public class ShipVisitDetailsVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String vesselName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String visitor;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String portFrom;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String portTo;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String visitType;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String dateIn;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String dateOut;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String virDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String visitDays;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String nextDuedate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String reviewDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String virSenttoowner;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String remark;
	
	public void setDateIn(String dateIn){
        this.dateIn = Util.dateFormat(dateIn,"yyyy-MM-dd");
    }
	
	public void setDateOut(String dateOut){
        this.dateOut = Util.dateFormat(dateOut,"yyyy-MM-dd");
    }
	
	public void setVirDate(String virDate){
        this.virDate = Util.dateFormat(virDate,"yyyy-MM-dd");
    }
	
	public void setNextDuedate(String nextDuedate){
        this.nextDuedate = Util.dateFormat(nextDuedate,"yyyy-MM-dd");
    }
	
	public void setReviewDate(String reviewDate){
        this.reviewDate = Util.dateFormat(reviewDate,"yyyy-MM-dd");
    }
	
	public void setVesselName(String vesselName){
        this.vesselName = Util.stringFormat(vesselName);
    }
	
	public void setVisitor(String visitor){
        this.visitor = Util.stringFormat(visitor);
    }
	
	public void setPortFrom(String portFrom){
        this.portFrom = Util.stringFormat(portFrom);
    }
	
	public void setPortTo(String portTo){
        this.portTo = Util.stringFormat(portTo);
    }
}
