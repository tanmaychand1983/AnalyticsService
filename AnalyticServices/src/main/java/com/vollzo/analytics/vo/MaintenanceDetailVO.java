/**
 * {@summary}: This is the VO class for Maintenance Details Dashboard.
 * @className: MaintenanceDetailVO
 * @author Deepak Bansal
 * @since: Mar 13, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
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
public class MaintenanceDetailVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String vesselName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String age;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String rankName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String jobNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String jobType;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String frequency;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastDone;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String nextDue;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String critical;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String scheduledDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String component;
	
	public void setVesselName(String vesselName){
        this.vesselName = Util.stringFormat(vesselName);
    }
	public void setComponent(String component){
        this.component = Util.stringFormat(component);
    }
	public void setScheduledDate(String scheduledDate){
        this.scheduledDate = Util.dateFormat(scheduledDate,"yyyy-MM-dd");
    }
	public void setLastDone(String lastDone){
        this.lastDone = Util.dateFormat(lastDone,"yyyy-MM-dd HH:mm:ss");
    }
	public void setNextDue(String nextDue){
        this.nextDue = Util.dateFormat(nextDue,"yyyy-MM-dd HH:mm:ss");
    }
}
