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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="threatreid")
	Theatre threatre;
	
	@OneToOne(mappedBy="show")
	Movie movie;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="Screenid")
	private Screen screen;

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
	@JsonIgnore
	public Theatre getThreatre() {
		return threatre;
	}

	public void setThreatre(Theatre threatre) {
		this.threatre = threatre;
	}
	@JsonIgnore
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	@JsonIgnore
	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	
	
	
	
}
