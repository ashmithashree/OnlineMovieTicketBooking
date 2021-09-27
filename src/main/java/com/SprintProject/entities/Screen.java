package com.SprintProject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="screen")
@Table(name="screen")
public class Screen {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int screenId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="theatre_id",nullable=false)
	private Theatre theatre;
	
	@Column(name="name")
	private String screenName;
	
	@OneToMany(mappedBy="screen",cascade=CascadeType.ALL)
	private List<Show> showList=new ArrayList<Show>();
	private int rows;
	private int columns;
	
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public void setShowList(List<Show> showList) {
		this.showList = showList;
		for(Show s:showList) {
			s.setScreen(this);
		}
	}
	@JsonIgnore
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public List<Show> getShowList() {
		return showList;
	}
	
}