package com.ticketbooking.movie_service.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.movie_service.DTO.ApiResponse;
import com.ticketbooking.movie_service.DTO.MovieRequest;
import com.ticketbooking.movie_service.DTO.MovieResponse;
import com.ticketbooking.movie_service.Entity.Movie;
import com.ticketbooking.movie_service.Service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
	private MovieService movieService;
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	@GetMapping
	public ResponseEntity<ApiResponse<List<MovieResponse>>> findAllMovies() {
		List<MovieResponse> movies = movieService.findAllMovies();
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("Movies fetched Successfully", movies));
		
	}
	@PostMapping
	public ResponseEntity<ApiResponse<List<MovieResponse>>> addMovies(@RequestBody List<MovieRequest> req) {
		List<MovieResponse> movieResp = movieService.addAllMovies(req);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("Movies Added SuccessFully", movieResp));
	}
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<MovieResponse>> getMovieById(@PathVariable("id") long id) {
		MovieResponse response = movieService.findMovieById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>("MovieFetched Successfully", response));
	}

}
