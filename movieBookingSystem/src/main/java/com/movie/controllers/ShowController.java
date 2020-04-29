package com.movie.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entities.Seat;
import com.movie.entities.Show;
import com.movie.exceptions.EntityNotFoundException;
import com.movie.services.IShowService;

@RestController
@CrossOrigin(origins="/*")
public class ShowController {

	@Autowired
	IShowService service;
	
	@GetMapping(value="show/{id}")

	public Show getShow(@PathVariable Integer id,HttpServletResponse response)
	{
		Show show;
		try {
			show = service.getShow(id);
		} catch (NullPointerException | EntityNotFoundException e) {
			// TODO Auto-generated catch block
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return null;
		}
		return show;
	}
	

	@GetMapping(value="show/{id}/seats")
	public List<Seat> getOnlySeats(@PathVariable Integer id,HttpServletResponse response) throws NullPointerException, EntityNotFoundException
	{
		Show show = null;
		show = service.getShow(id);
		return show.getSeats();
	}
	
	@GetMapping(value="sandeep/{id}")
	public Seat getSomething(@PathVariable Integer id) throws Exception
	{
		if(id==1)
		{
			throw new NullPointerException("no data to provide");
		}
		if(id==2)
		{
			throw new EntityNotFoundException();
		}
		if(id==3)
		{
			throw new DataIntegrityViolationException("unique is vpoileated");
		}
		return null;
		
	}
	@ExceptionHandler(EntityNotFoundException.class)
	public String exceptionHandler()
	{
		return "Entity not found";
	}
	
}