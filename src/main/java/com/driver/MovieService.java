package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie) {
      movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public String addMovieDirectorPair(String movieName,String directorName){
        return movieRepository.addMovieDirectorPair(movieName,directorName);
    }
    public Movie getMovieByName(String movieName) {
        return movieRepository.getMovieByName(movieName);
    }
    public Director getDirectorByName(String directorName) {
      return movieRepository.getDirectorByName(directorName);
    }
    public List<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirectorName(directorName);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByName(directorName);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
