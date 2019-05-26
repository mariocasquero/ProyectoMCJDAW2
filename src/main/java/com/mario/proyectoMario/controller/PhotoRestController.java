package com.mario.proyectoMario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mario.proyectoMario.model.Photo;
import com.mario.proyectoMario.service.PhotoService;

@RestController
public class PhotoRestController {
	
	@Autowired
	PhotoService ps;
	
	/**
	 * Returns all the photo routes from the DB
	 * 
	 * @return List<Photo> a collection of all the photo routes.
	 */
	@GetMapping("/api/list")
	public List<Photo> showPhotos(){
		return ps.getPhotos();
	}
	
	/**
	 * Saves a photo route in the db
	 * 
	 * @param photo the photo route that will be mapped into the db
	 * @return boolean true if all was right
	 */
	@PostMapping("/api/save")
	public boolean guardarPhoto(Photo photo) {
		return ps.savePhoto(photo);
	}
	
	/**
	 * Returns an specific photo route from the DB
	 * 
	 * @param Integer id
	 * @return Optional<Photo> an entity that represents the photo route, if it isn't exists, entity will be null
	 */
	@GetMapping("/api/getPhoto")
	public Optional<Photo> getPhoto(Integer id){
		return ps.searchPhoto(id);
	}
	
	/**
	 * Modifies an existing photo route from the db
	 * 
	 * @param id the id from the photo route to modify
	 * @param newPhoto the object that contains the attributes to change in the db's photo route
	 */
	@PostMapping("/api/update")
	public boolean updatePhoto(Integer id, Photo photo) {
		return ps.updatePhoto(id, photo);
	}
	
	/**
	 * Deletes a specific photo route from the db
	 * 
	 * @param id the id of the photo route to delete
	 */
	@GetMapping("/api/deletePhoto")
	public void deletePhoto(Integer id) {
		ps.deletePhoto(id);
	}
	
	/**
	 * Delete all the photo routes from the db
	 */
	@GetMapping("/api/deleteAllPhotos")
	public void deleteAllPhotos() {
		ps.deleteAllPhotos();
	}
}
