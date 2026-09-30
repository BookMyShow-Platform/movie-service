package com.ticketbooking.movie_service.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	@ManyToOne
	@JoinColumn(name = "certificate_id")
	private Certificate certificate;
	private int duration_minutes;
	@ManyToOne
	@JoinColumn(name = "language_id")
	private MovieLanguage language;
	private LocalDate releaseDate;
	private String posterUrl;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	public Movie() {
		super();
	}
    
	public Movie(long id, String title, String description, Genre genre, Certificate certificate, int duration_minutes,
			MovieLanguage language, LocalDate releaseDate, String posterUrl, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
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
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Certificate getCertificate() {
		return certificate;
	}
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
	public int getDuration_minutes() {
		return duration_minutes;
	}
	public void setDuration_minutes(int duration_minutes) {
		this.duration_minutes = duration_minutes;
	}
	public MovieLanguage getLanguage() {
		return language;
	}
	public void setLanguage(MovieLanguage language) {
		this.language = language;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
