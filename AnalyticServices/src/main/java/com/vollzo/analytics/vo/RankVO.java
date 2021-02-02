/**
 * {@summary}: This is the Responsibility VO for Maintenance Dashboard.
 * @className: RankVO
 * @author: Deepak Bansal
 * @since: Feb 02, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RankVO {
	
	private Integer rankId;
	private String rankName;
}
