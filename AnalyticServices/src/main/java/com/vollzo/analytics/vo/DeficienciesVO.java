/**
 * {@summary}: This is the  Deficiencies Data VO use for Port state Control 
 * dashboard modal dialog.
 * @className: DeficienciesVO
 * @author: Deepak Bansal
 * @since: Feb 17, 2021
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
public class DeficienciesVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String dueDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String natureofDeficiency;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String defectCode;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String actionCodes;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String deficiencieStatus;
	
	public void setDeficiencieStatus(String deficiencieStatus){
        this.deficiencieStatus = Util.stringFormat(deficiencieStatus);
    }
}
