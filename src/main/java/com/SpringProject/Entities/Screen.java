package com.SpringProject.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="theater_id",nullable=false)
	private Theater theaterId;
	@Column(name="name")
	private String screenName;
	private List<Show> showList=new ArrayList<Show>();
	private int rows;
	private int columns;
	
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	@JsonIgnore
	public Theater getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(Theater theater) {
		this.theaterId = theater;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public List<Show> getShowList() {
		return showList;
	}
	public void setShowList(List<Show> showList) {
		this.showList = showList;
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
}
