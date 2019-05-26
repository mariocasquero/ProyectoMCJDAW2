package com.mario.proyectoMario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mario.proyectoMario.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer>, CrudRepository<Photo, Integer>{
	
}
