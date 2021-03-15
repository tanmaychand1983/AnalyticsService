package com.vollzo.analytics.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VesselVO {
	 
	private Integer vesselId;
	private String  vesselDesc;
	
	public void setVesselDesc(String vesselDesc){
        this.vesselDesc = Util.stringFormat(vesselDesc);
    }
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private CategoryVO categoryVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private StatusVO statusVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private MaterialTypeVO materialTypeVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private SeverityVO severityVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private VendorVO vendorVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private BudgetCodeVO budgetCodeVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ReferenceDataVO referenceDataVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private AuditTypeVO auditTypeVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private RankVO rankVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private MouVO mouVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private VisitTypeVO visitTypeVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LoadingConditionVO loadingConditionVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private WeatherVO weatherVO;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ReasonVO reasonVO;
}
