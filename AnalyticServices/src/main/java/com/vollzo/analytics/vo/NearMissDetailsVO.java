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
}
