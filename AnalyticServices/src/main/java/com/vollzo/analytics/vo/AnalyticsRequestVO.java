package com.vollzo.analytics.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@summary}: This is the Request VO class for Analytical Module.
 * 
 * @className: AnalyticsRequestVO
 * @author Ajaya Kar
 * @since: Feb 1, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnalyticsRequestVO {
	private String startDate;
	private String endDate;
	private String vesselIds;
}
