package com.SprintProject.entities;

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
import com.SprintProject.entities.Movie;

@Entity(name="theatre")
@Table(name="theatre")
public class Theatre {
	private static final long serialVersionUID =1L;
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
	
	public int gettheatreId() {
		return theatreId;
	}
	public void settheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String gettheatreName() {
		return theatreName;
	}
	public void settheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String gettheatreCity() {
		return theatreCity;
	}
	public void settheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
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