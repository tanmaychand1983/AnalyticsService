/**
 * {@summary}: This is the VO class use for Downtime Dashboard Filter.
 * @className: ReasonVO
 * @author Deepak Bansal
 * @since: Mar 15, 2021
 * @version: 1.0.0
 * @revision: {Name: Date: Reason:} 
 */
package com.vollzo.analytics.vo;

import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReasonVO {
	
	private String reason;
	
	public void setReason(String reason){
        this.reason = Util.stringFormat(reason);
    }
}
