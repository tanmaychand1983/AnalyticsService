package com.vollzo.analytics.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnalyticsRequestVO {
	private String startDate;
	private String endDate;
	private String vesselIds;
}
