package com.SpringProject.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="theater")
@Table(name="theater")
public class Theater {
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int TheaterId;
	@Column(name="name")
	private String theaterName;
	@Column(name="city")
	private String theaterCity;
	@OneToMany(mappedBy="movie",cascade=CascadeType.ALL)
	private List<Movie> listOfMovies=new ArrayList<Movie>();
	@OneToMany(mappedBy="screen",cascade=CascadeType.ALL)
	private List<Screen> listOfScreens=new ArrayList<Screen>();
	private String managerName;
	private String managerContact;
	public int getTheaterId() {
		return TheaterId;
	}
	public void setTheaterId(int theaterId) {
		TheaterId = theaterId;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterCity() {
		return theaterCity;
	}
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}
	public List<Movie> getListOfMovies() {
		return listOfMovies;
	}
	public void setListOfMovies(List<Movie> listOfMovies) {
		this.listOfMovies = listOfMovies;
		for(Movies sc: listOfMovies)
		{
			sc.setMovieId(this);
		}
	}
	public List<Screen> getListOfScreens() {
		return listOfScreens;
	}
	public void setListOfScreens(List<Screen> listOfScreens) {
		this.listOfScreens = listOfScreens;
		for(Screen sc: listOfScreens)
		{
			sc.setTheaterId(this);
		}
		
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	
}
