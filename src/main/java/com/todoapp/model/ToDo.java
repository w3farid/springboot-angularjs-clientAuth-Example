package com.todoapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "todos")
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "toDoTitle")
	private String toDoTitle;
	
	@Column(name = "createdDate")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name = "updateDate")
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	
	@Column(name = "createByUsername")	
	private String createByUsername;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToDoTitle() {
		return toDoTitle;
	}

	public void setToDoTitle(String toDoTitle) {
		this.toDoTitle = toDoTitle;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateByUsername() {
		return createByUsername;
	}

	public void setCreateByUsername(String createByUsername) {
		this.createByUsername = createByUsername;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", toDoTitle=" + toDoTitle + ", createdDate=" + createdDate + ", updateDate="
				+ updateDate + ", createByUsername=" + createByUsername + "]";
	}

	
	
	
}
