
package com.vollzo.analytics.entity;
  
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * {@summary}: This is the Base Entity class.
 * 
 * @className: BaseEntity
 * @author Ajaya Kar
 * @since: Jan 23, 2021
 * @version: 1.0.0
 * 
 * @revision: {Name: Date: Reason:} 
 * 
 */
@MappedSuperclass
@Getter
@Setter
@Data
public class BaseEntity {
	@Id
	private Integer id;
}
 