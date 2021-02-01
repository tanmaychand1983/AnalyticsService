package com.vollzo.analytics.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReferenceDataVO {
    private String refNumber;
    private String reportedDate;
    private String reportedBy;
    private String title;
}
