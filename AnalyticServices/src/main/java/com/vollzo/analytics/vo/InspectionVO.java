/**
 * {@summary}: This is the  Inspection Data VO use for Port state Control 
 * dashboard modal dialog.
 * @className: InspectionVO
 * @author: Deepak Bansal
 * @since: Feb 17, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InspectionVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String inspectionNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String inspectionDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String portName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String mou;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String otherMou;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String masterName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String chiefengineerName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<DeficienciesVO> deficienciesVO;
	
	public void setPortName(String portName){
        this.portName = Util.stringFormat(portName);
    }
	
	public void setChiefengineerName(String chiefengineerName){
        this.chiefengineerName = Util.stringFormat(chiefengineerName);
    }
	
	public void setMasterName(String masterName){
        this.masterName = Util.stringFormat(masterName);
    }
	
}
