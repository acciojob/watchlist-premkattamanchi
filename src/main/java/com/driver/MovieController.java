package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
   @Autowired
    MovieService movieService;

   @PostMapping ("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
       movieService.addMovie(movie);
       return new ResponseEntity<>("movie added",HttpStatus.CREATED);
   }
   @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
       movieService.addDirector(director);
       return new ResponseEntity<>("director added",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("d") String directorName,@RequestParam("m") String movieName) {
          String s=movieService.addMovieDirectorPair(directorName,movieName);
          if(s!=null)
              return new ResponseEntity<>(s,HttpStatus.CREATED);
          return new ResponseEntity<>("not present",HttpStatus.NO_CONTENT);
    }
    @GetMapping("/get_movie")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("m") String movieName) {
      Movie movie=movieService.getMovieByName(movieName);
       return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }
    @GetMapping("/get_director")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("d") String directorName) {
        Director director=movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName){
        List<String> l=movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(l,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
       List<String> l=movieService.findAllMovies();
       return new ResponseEntity<>(l,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("d") String directorName){
       movieService.deleteDirectorByName(directorName);
       return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
       movieService.deleteAllDirectors();
       return new ResponseEntity<>("all directors deleted",HttpStatus.OK);
    }

}
