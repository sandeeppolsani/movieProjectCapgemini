package com.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entities.Screen;
import com.movie.entities.Show;
import com.movie.entities.Theatre;
import com.movie.services.IScreenService;
import com.movie.services.ITheatreService;

@CrossOrigin(origins="localhost:4200")
@RestController
public class ScreenController {

	@Autowired
	IScreenService service;
	
	@Autowired
	ITheatreService theatreservice;
	
	@GetMapping(value="screen/{id}")
	public Screen getScreen(@PathVariable Integer id)
	{
		return service.getScreen(id);
	}
	
	@GetMapping(value="screen/{id}/shows")
	public List<Show> getShows(@PathVariable Integer id)
	{
		return service.getScreen(id).getShow();
	}
	
	@GetMapping(value="screens")
	public List<Screen> getScreens()
	{
		return service.getAllScreens();
	}
	
	
}