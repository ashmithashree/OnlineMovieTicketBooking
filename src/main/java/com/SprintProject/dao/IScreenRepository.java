package com.SprintProject.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SprintProject.entities.Screen;
@Repository(value="IScreenRepository")
public interface IScreenRepository extends JpaRepository<Screen, Integer>{

}
