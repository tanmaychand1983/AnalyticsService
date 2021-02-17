/**
 * {@summary}: This is the  Non Conformity Data VO for modal dialog.
 * @className: NonConformityDetailsVO
 * @author: Deepak Bansal
 * @since: Feb 17, 2021
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
public class NonConformityDetailsVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String documentReference;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String thetisCode;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String dueDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String summary;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String immediateAction;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String rootCause;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String correctiveAction;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String longtermAction;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String completionDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String closeoutDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String closeoutRemarks;

}
