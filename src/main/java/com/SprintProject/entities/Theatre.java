package com.SprintProject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="theatre")
@Table(name="theatre")
public class Theatre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int theatreId;
	@Column(name="name")
	private String theatreName;
	@Column(name="city")
	private String theatreCity;
	@OneToMany(mappedBy="theatre",cascade=CascadeType.ALL)
	private List<Movie> listOfMovies=new ArrayList<Movie>();
	@OneToMany(mappedBy="theatreId",cascade=CascadeType.ALL)
	private List<Screen> listOfScreens=new ArrayList<Screen>();
	private String managerName;
	private String managerContact;
	@OneToMany(mappedBy="threatreId",cascade=CascadeType.ALL)
	private List<Show> listOfShows=new ArrayList<Show>();
	
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreCity() {
		return theatreCity;
	}
	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}
	public List<Show> getListOfShows() {
		return listOfShows;
	}
	public void setListOfShows(List<Show> listOfShows) {
		this.listOfShows = listOfShows;
		for(Show s:listOfShows)
		{
			s.setThreatreId(this);
		}
	}
	
	public List<Movie> getListOfMovies() {
		return listOfMovies;
	}
	public void setListOfMovies(List<Movie> listOfMovies) {
		this.listOfMovies = listOfMovies;
		for(Movie sc: listOfMovies)
		{
			sc.setTheatre(this);
		}
	}
	public List<Screen> getListOfScreens() {
		return listOfScreens;
	}
	public void setListOfScreens(List<Screen> listOfScreens) {
		this.listOfScreens = listOfScreens;
		for(Screen sc: listOfScreens)
		{
			sc.setTheatreId(this);
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