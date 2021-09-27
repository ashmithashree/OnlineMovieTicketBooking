package com.SprintProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.SprintProject.entities.Theatre;
@Repository
public interface ITheatreRepository extends JpaRepository<Theatre, Integer> {

}