package com.vollzo.analytics.vo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnalyticsVO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String unitId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String unitName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> vesselList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> categoryList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> statusList;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> severityList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<GridVO> dataList;
	
	/*
	 * @Comments: Additional Filter for Non Conformity Dashboard
	 * @Author: Deepak Bansal
	 * @Date: Jan 28, 2021
	 */
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> authTypeList;
	
	
}
