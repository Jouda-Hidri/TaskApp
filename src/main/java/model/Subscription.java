package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subscription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Persistent Fields:
	@Id
	@GeneratedValue
	private Long id;
	private Long userId;
	private Long groupId;
	
	public Subscription() {
		this.userId = 1L;
		this.groupId=1L;
	}
	
	public Subscription(Long userId, Long groupId) {
		this.userId = userId;
		this.groupId=groupId;
	}

	// String Representation:
	@Override
	public String toString() {
		return userId + " - " + getGroupId();
	}

	public Long getGroupId() {
		return groupId;
	}
}
