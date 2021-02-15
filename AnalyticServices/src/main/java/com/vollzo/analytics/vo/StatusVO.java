package com.vollzo.analytics.vo;

import com.vollzo.analytics.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusVO {
  
	private Integer statusId;
	private String statusDesc;
	
	public void setStatusDesc(String statusDesc){
        this.statusDesc = Util.stringFormat(statusDesc);
    }
}
