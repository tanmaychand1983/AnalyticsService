
package com.vollzo.analytics.entity;
  
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
  
@MappedSuperclass
@Getter
@Setter
@Data
public class BaseEntity {
	@Id
	private int id;
}
 