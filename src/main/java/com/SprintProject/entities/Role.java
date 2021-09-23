package com.SprintProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
    public static final String USER = "USER";
    public static final String ADMIN = "ADMIN";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private Integer id; 
	@Enumerated(EnumType.STRING)
	@Column(name="role_name")
	private Roles roleName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Roles getRoleName() {
		return roleName;
	}
	public void setRoleName(Roles roleName) {
		this.roleName = roleName;
	}
}
