package com.vollzo.nearMiss.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class NearMissEntity {
	@Id
	private long id;	
	private String category;//varchar(100)	
	private String subcategory ;// varchar(100)
	private int vesselid;// int(5)
	
	
	//@Column(name="RefNumber")
	//private String refNumber;// varchar(15) 
	//@Column(name="ReportedDate")
	//private String reportedDate ;
	
	/*private String reportedDate ;// date 
	private String type ;// varchar(25) 
	private int number;// int(10) 
	
	private String latitudeDir;// varchar(1) 
	private String latitudeDegree;//varchar(3) 
	private String latitudeMinute; // varchar(5) 
	private String longitudeDir; //varchar(1) 
	private String longitudeDegree; // varchar(3) 
	private String longitudeMinute; // varchar(5) 
	private int portId;// int(11) UN 
	private String description; // text 
	private String immediateAction; //text 
	private String rootCause; // text 
	private String correctiveAction; // text 
	private String preventiveAction; //text 
	private String date; // date 
	private String master; // varchar(100) 
	private String verificationInstruction; // text 
	private String verificationDate;// date 
	private String techSuprintendentName; //varchar(100) 
	private String supportingDocument;//varchar(100) 
	private String mSCATData; //text 
	private String eventHistory; // text 
	private String investigationReport; // varchar(100) 
	private String status;//int(2) 
	private String activeOrNot;// int(1) 
	private String reportName;// varchar(15) 
	private String investigationReportName; // varchar(255) 
	private int createdByUserId; //int(11) 
	private String createdOn; //datetime 
	private int updatedByUserId;// int(11) 
	private String updatedOn; // datetime
	*/
	 @Override
	    public String toString() {
	        return "NearMissEntity [id=" + id + ", category=" + category + 
	                ", SubCategory=" + subcategory + ", vesselId=" + vesselid   + 
	                "]";
	    }
	
}
