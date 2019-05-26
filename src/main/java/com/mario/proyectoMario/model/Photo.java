package com.mario.proyectoMario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	public String ruta;
	
	public Photo() {
		
	}
	
	public Photo(String ruta) {
		this.ruta=ruta;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getRuta() {
		return ruta;
	}
	
	public void setRuta(String ruta) {
		this.ruta=ruta;
	}
	
	public String toString() {
		return ruta;
	}
}
