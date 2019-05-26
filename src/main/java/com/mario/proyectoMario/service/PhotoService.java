package com.mario.proyectoMario.service;

import java.util.List;
import java.util.Optional;

import com.mario.proyectoMario.model.Photo;

public interface PhotoService {
	public List<Photo> getPhotos();
	public boolean savePhoto(Photo photo);
	public boolean updatePhoto(Integer id, Photo photo);
	public Optional<Photo> searchPhoto(Integer id);
	public void deletePhoto(Integer id);
	public void deleteAllPhotos();
}
