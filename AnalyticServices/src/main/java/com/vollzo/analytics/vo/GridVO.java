package com.vollzo.analytics.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GridVO {
	
	private int id;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String vesselId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String vesselName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String categoryId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String categoryName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String title;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String refNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String reportedDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String reportedBy;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String statusId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String statusName;
}
