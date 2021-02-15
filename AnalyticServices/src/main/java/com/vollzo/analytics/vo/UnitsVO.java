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
public class UnitsVO {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer unitId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String unitDesc;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<VesselVO> vesselVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<SeverityVO> severityVO;
	
	public void setUnitDesc(String unitDesc){
        this.unitDesc = Util.stringFormat(unitDesc);
    }
		
}
