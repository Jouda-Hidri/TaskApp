package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Persistent Fields:
	@Id
	@GeneratedValue
	private
	Long id;
	private String title;
	private String description;
	private Long userId; // TODO switch to entity
	private Long groupId; // TODO switch to entity

	public Todo() {
		this.title="no title";
		this.description = "no description";
		this.setUserId(2L);
		this.setGroupId(1L);
	}

	public Todo(String title, String description) {
		this.title=title;
		this.description = description;
		this.setUserId(2L);
		this.setGroupId(1L);
	}

	// String Representation:
	@Override
	public String toString() {
		return "[" + getId() + "] " + getTitle() + " : " + description;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}
