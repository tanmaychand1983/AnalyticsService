package com.vollzo.analytics.vo;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnalyticsResponseVO {
	private Map<String, AnalyticsVO> unitList;
	
}
