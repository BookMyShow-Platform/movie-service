package com.ticketbooking.movie_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.movie_service.Entity.Genre;
@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {

}
