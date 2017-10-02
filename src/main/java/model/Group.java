package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Group implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	private String title;
	private String description;

	public Group() {
		this.title = "no title";
		this.description = "no description";
	}

	public Group(String title, String description) {
		this.title = title;
		this.description = description;
	}

	// String Representation:
	@Override
	public String toString() {
		return "[" + id + "] " + title + " : " + description;
	}

}
