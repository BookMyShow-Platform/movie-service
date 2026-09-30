package com.ticketbooking.movie_service.DTO;

import java.time.LocalDate;

import com.ticketbooking.movie_service.Entity.Certificate;
import com.ticketbooking.movie_service.Entity.Genre;
import com.ticketbooking.movie_service.Entity.MovieLanguage;

public class MovieResponse {
	private long id;
	private String title;
	private String description;
	private long genre;
	private long certificate;
	private int duration_minutes;
	private long language;
	private LocalDate releaseDate;
	private String posterUrl;
	public MovieResponse() {
		super();
	}
	public MovieResponse(long id, String title, String description, long genre, long certificate, int duration_minutes,
			long language, LocalDate releaseDate, String posterUrl) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.genre = genre;
		this.certificate = certificate;
		this.duration_minutes = duration_minutes;
		this.language = language;
		this.releaseDate = releaseDate;
		this.posterUrl = posterUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getGenre() {
		return genre;
	}
	public void setGenre(long genre) {
		this.genre = genre;
	}
	public long getCertificate() {
		return certificate;
	}
	public void setCertificate(long certificate) {
		this.certificate = certificate;
	}
	public int getDuration_minutes() {
		return duration_minutes;
	}
	public void setDuration_minutes(int duration_minutes) {
		this.duration_minutes = duration_minutes;
	}
	public long getLanguage() {
		return language;
	}
	public void setLanguage(long language) {
		this.language = language;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getPosterUrl() {
		return posterUrl;
	}
	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}
	
}
