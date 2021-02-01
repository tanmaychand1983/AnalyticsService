package com.vollzo.analytics.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VesselVO {
	 
	private Integer vesselId;
	private String  vesselDesc;
	
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
	
	
}
