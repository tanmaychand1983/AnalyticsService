/**
 * {@summary}: This is the Entity class for Port State Details Details Modal Dialog.
 * 
 * @className: PortStateControlDetailsEntity
 * @author Deepak Bansal
 * @since: Feb 17, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */
package com.vollzo.analytics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class PortStateControlDetailsEntity extends BaseEntity {
	
	@Column(name = "inspection_number")
	private String inspectionNumber;
	
	@Column(name = "inspection_date")
	private String inspectionDate;
	
	@Column(name = "port_name")
	private String portName;
	
	@Column(name = "mou")
	private String mou;
	
	@Column(name = "other_mou")
	private String otherMou;
	
	@Column(name = "master_name")
	private String masterName;
	
	@Column(name = "chiefengineer_name")
	private String chiefengineerName;
	
	@Column(name = "due_date")
	private String dueDate;
	
	@Column(name = "natureof_deficiency")
	private String natureofDeficiency;
	
	@Column(name = "defect_code")
	private String defectCode;
	
	@Column(name = "action_codes")
	private String actionCodes;
	
	@Column(name = "deficiencie_status")
	private String deficiencieStatus;
	
//	@Override
//    public String toString() {
//		 return "PortStateControlDetailsEntity [inspectionNumber=" + inspectionNumber + ", inspectionDate=" + inspectionDate +
//				 ", portName=" + portName + ", mou="+ mou +
//				 ", otherMou=" + otherMou + ", masterName="+ masterName +
//				 ", chiefengineerName=" + chiefengineerName + ", dueDate="+ dueDate +
//				 ", natureofDeficiency=" + natureofDeficiency + ", defectCode="+ defectCode +
//				 ", actionCodes=" + actionCodes + ", deficiencieStatus="+ deficiencieStatus +
//				 "]";
//	}
}
