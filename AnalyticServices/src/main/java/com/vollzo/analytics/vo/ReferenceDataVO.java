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
}
