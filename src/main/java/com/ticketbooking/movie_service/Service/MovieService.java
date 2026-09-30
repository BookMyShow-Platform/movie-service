package com.ticketbooking.movie_service.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ticketbooking.movie_service.DTO.MovieRequest;
import com.ticketbooking.movie_service.DTO.MovieResponse;
import com.ticketbooking.movie_service.Entity.Certificate;
import com.ticketbooking.movie_service.Entity.Genre;
import com.ticketbooking.movie_service.Entity.Movie;
import com.ticketbooking.movie_service.Entity.MovieLanguage;
import com.ticketbooking.movie_service.Exception.DuplicateResourceException;
import com.ticketbooking.movie_service.Exception.ResourceNotFoundException;
import com.ticketbooking.movie_service.Repository.CertRepo;
import com.ticketbooking.movie_service.Repository.GenreRepo;
import com.ticketbooking.movie_service.Repository.LangRepo;
import com.ticketbooking.movie_service.Repository.MovieRepo;
@Service
public class MovieService {
	private MovieRepo movieRepo;
	private CertRepo certRepo;
	private LangRepo langRepo;
	private GenreRepo genreRepo;
	public MovieService(MovieRepo movieRepo, CertRepo certRepo, LangRepo langRepo, GenreRepo genreRepo) {
		this.movieRepo = movieRepo;
		this.certRepo = certRepo;
		this.langRepo = langRepo;
		this.genreRepo = genreRepo;
	}
	@Cacheable(value = "movies", key = "'all'")
	public List<MovieResponse> findAllMovies() {
		List<Movie> movies = movieRepo.findAll();
		List<MovieResponse> responses = new ArrayList<>();
		for (Movie movie:movies) {
			MovieResponse response = new MovieResponse();
			response.setId(movie.getId());
			response.setTitle(movie.getTitle());
			response.setDescription(movie.getTitle());
			response.setDuration_minutes(movie.getDuration_minutes());
			response.setReleaseDate(movie.getReleaseDate());
			response.setCertificate(movie.getCertificate().getId());
			response.setLanguage(movie.getLanguage().getId());
			response.setGenre(movie.getLanguage().getId());
			response.setPosterUrl(movie.getPosterUrl());
			responses.add(response);
		}
		return responses;
		
	}
	@CacheEvict(value = "movies", key = "'all'")
	public List<MovieResponse> addAllMovies(List<MovieRequest> movieRequests) {
		List<Movie> movies = new ArrayList<>();
		
		Set<Long> certIds = new HashSet<>();
		Set<Long> langIds = new HashSet<>();
		Set<Long> genreIds = new HashSet<>();
 		
		for (MovieRequest movieReq :movieRequests) {
			
			Long certId = movieReq.getCertificate();
			certIds.add(certId);
			Long genreId = movieReq.getGenre();
			genreIds.add(genreId);
			Long langId = movieReq.getLanguage();
			langIds.add(langId);
		
		}
		List<MovieLanguage> langs = langRepo.findAllById(langIds);
		List<Certificate> certs = certRepo.findAllById(certIds);
		List<Genre> genres = genreRepo.findAllById(genreIds);
		if (genres.size() != genreIds.size()) {
			throw new ResourceNotFoundException("Some genres not found");
		}
		
		for (MovieRequest movieReq :movieRequests) {
			Movie movie = new Movie();
			movie.setTitle(movieReq.getTitle());
			movie.setDescription(movieReq.getDescription());
			for (Genre genre :genres) {
				if (genre.getId() == movieReq.getGenre()) {
					movie.setGenre(genre);
				}
			}
			for (Certificate cert :certs) {
				if (cert.getId() == movieReq.getCertificate()) {
					movie.setCertificate(cert);
				}
			}
			for (MovieLanguage lang: langs) {
				if(lang.getId() == movieReq.getLanguage()) {
					movie.setLanguage(lang);
				}
			}
			movie.setDuration_minutes(movieReq.getDuration_minutes());
			movie.setPosterUrl(movieReq.getPosterUrl());
			movie.setReleaseDate(movieReq.getReleaseDate());
			movies.add(movie);
		}
		List<Movie> savedMovies = new ArrayList<>();
		try {
		 savedMovies = movieRepo.saveAll(movies);
		}catch(DataIntegrityViolationException ex) {
			throw new DuplicateResourceException("MovieAlreadyExists");
		}
		List<MovieResponse> responses = new ArrayList<>();
		for (Movie saved :savedMovies) {
			MovieResponse res = new MovieResponse();
			res.setId(saved.getId());
			res.setTitle(saved.getTitle());
			res.setDescription(saved.getDescription());
			res.setCertificate(saved.getCertificate().getId());
			res.setDuration_minutes(saved.getDuration_minutes());
			res.setGenre(saved.getGenre().getId());
			res.setLanguage(saved.getLanguage().getId());
			res.setPosterUrl(saved.getPosterUrl());
			res.setReleaseDate(saved.getReleaseDate());
			responses.add(res);
			
		}
		return responses;
	}
	@Cacheable(value = "movies", key = "#p0")
	public MovieResponse findMovieById(long id) {
		Movie movie = movieRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
		MovieResponse res = new MovieResponse();
		res.setId(movie.getId());
		res.setTitle(movie.getTitle());
		res.setDescription(movie.getDescription());
		res.setCertificate(movie.getCertificate().getId());
		res.setDuration_minutes(movie.getDuration_minutes());
		res.setGenre(movie.getGenre().getId());
		res.setReleaseDate(movie.getReleaseDate());
		res.setLanguage(movie.getLanguage().getId());
		res.setPosterUrl(movie.getPosterUrl());
		
		return res;
	}

}
