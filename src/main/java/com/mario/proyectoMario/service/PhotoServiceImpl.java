package com.mario.proyectoMario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.proyectoMario.model.Photo;
import com.mario.proyectoMario.repository.PhotoRepository;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	PhotoRepository pr;
	
	@Override
	public List<Photo> getPhotos() {
		return pr.findAll();
	}

	@Override
	public boolean savePhoto(Photo photo) {
		if(pr.save(photo)!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updatePhoto(Integer id, Photo photo) {
		Photo oldPhoto=searchPhoto(id).get();
		if(oldPhoto==null) {
			return false;
		}
		oldPhoto.setRuta(photo.getRuta());
		return savePhoto(oldPhoto);
	}

	@Override
	public Optional<Photo> searchPhoto(Integer id) {
		return pr.findById(id);
	}

	@Override
	public void deletePhoto(Integer id) {
		pr.deleteById(id);
	}

	@Override
	public void deleteAllPhotos() {
		pr.deleteAll();		
	}
}
