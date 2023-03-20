package com.gnapoli13.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gnapoli13.app.model.Alien;

public interface AlienDao extends CrudRepository<Alien, Integer> {
	
	List<Alien> findByTech(String tech);
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> myquery(String tech);

}
