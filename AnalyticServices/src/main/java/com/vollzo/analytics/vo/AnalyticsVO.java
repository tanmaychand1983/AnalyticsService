package com.vollzo.analytics.vo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnalyticsVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<GridVO> dataList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<StatusVO> statusList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<CategoryVO> categoryList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<VesselVO> vesselList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<SeverityVO> severityList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String unitId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String unitName;
}
