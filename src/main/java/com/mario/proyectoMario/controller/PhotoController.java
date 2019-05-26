package com.mario.proyectoMario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhotoController {
	
	@GetMapping("/vista")
	public String getVista() {
		return "vista";
	}
}
