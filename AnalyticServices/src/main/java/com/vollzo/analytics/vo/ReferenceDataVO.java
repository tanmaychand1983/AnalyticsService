/**
 * {@summary}: This is the Reference Data VO for dashboard data.
 * @className: ReferenceDataVO
 * @author: Deepak Bansal
 * @since: Feb 01, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReferenceDataVO {
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String refNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String reportedDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String reportedBy;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String requisitionNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String poNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String poTitle;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requisitionFor;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer accountCode;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double totalAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String invoiceNo;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double invoiceAmount;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double netPay;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String portName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String stage;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String auditDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String dueDate;
	
}
