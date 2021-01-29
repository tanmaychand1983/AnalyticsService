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
	
	/*
	 * @Comments: Additional columns for Non Conformity Dashboard
	 * @Author: Deepak Bansal
	 * @Date: Jan 28, 2021
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String portName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String auditType;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String stage;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String auditDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String dueDate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requisitionNumber;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String poNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String poTitle;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String requisitionFor;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String accountCode;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String totalAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String invoiceNo;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String invoiceAmount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String netToPay;
}
