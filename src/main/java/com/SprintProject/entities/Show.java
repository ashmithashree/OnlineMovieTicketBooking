package com.SprintProject.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="show")
@Table(name="show")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int showId;
	LocalDateTime showStartTime;
	LocalDateTime showEndTime;
	String showName;
	

	int threatreId;
	
	
	@OneToOne(mappedBy ="show")
	Movie movie;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="Screenid", nullable =false)
	private Screen screenid;
	
	@JsonIgnore
	public Screen getScreenid() {
		return screenid;
	}
	public void setScreenid(Screen screenid) {
		this.screenid = screenid;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public LocalDateTime getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(LocalDateTime showStartTime) {
		this.showStartTime = showStartTime;
	}
	public LocalDateTime getShowEndTime() {
		return showEndTime;
	}
	public void setShowEndTime(LocalDateTime showEndTime) {
		this.showEndTime = showEndTime;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getThreatreId() {
		return threatreId;
	}
	public void setThreatreId(int threatreId) {
		this.threatreId = threatreId;
	}
	
}
