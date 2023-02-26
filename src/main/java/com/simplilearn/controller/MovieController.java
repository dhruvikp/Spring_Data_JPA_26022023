package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.Movie;
import com.simplilearn.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping("/movies")
	private List<Movie> getMovies() {
		return movieService.getMovies();
	}
	
	
	@PostMapping("/movies")
	private int saveMovie(@RequestBody Movie m) {
		movieService.saveMovie(m);
		return m.getId();
	}
	
	// http://localhost:8080/movies/30
	@DeleteMapping("/movies/{id}")
	private void deleteMove(@PathVariable("id") int id) {
		movieService.delete(id);
	}
}
