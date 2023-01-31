package com.driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class MovieRepository {
   private HashMap<String,Movie> movieMap;
   private HashMap<String,Director> directorMap;
   private HashMap<String,List<String>> pairMap;


    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.pairMap = new HashMap<>();
    }
    public void addMovie(Movie movie) {
        if (!movieMap.containsKey(movie.getName()))
            movieMap.put(movie.getName(), movie);
    }
    public void addDirector(Director director){
        if(!directorMap.containsKey(director.getName()))
            directorMap.put(director.getName(), director);
    }
    public String addMovieDirectorPair(String directorName,String movieName){
        String s=null;
      if(movieMap.containsKey(movieName) && directorMap.containsKey(directorName)) {
          if (!pairMap.containsKey(directorName))
              pairMap.put(directorName, new ArrayList<String>());
          pairMap.get(directorName).add(movieName);
          return "SUCCESS";
      }
      return s;
    }
    public Movie getMovieByName(String movieName){
        Movie movie=new Movie();
        if(movieMap.containsKey(movieName))
           movie=movieMap.get(movieName);
       return movie;
    }
    public Director getDirectorByName(String directorName){
        Director director=new Director();
        if(directorMap.containsKey(directorName))
            director=directorMap.get(directorName);
        return director;
    }
    public List<String> getMoviesByDirectorName(String directorName){
        List<String> l=new ArrayList<>();
        if(pairMap.containsKey(directorName))
            l=pairMap.get(directorName);
        return l;
    }
    public List<String> findAllMovies(){
       return new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirectorByName(String directorName){
        List<String> movies=new ArrayList<>();
        if(pairMap.containsKey(directorName))
            movies=pairMap.get(directorName);
        for(String movie:movies){
            if(movieMap.containsKey(movie))
                movieMap.remove(movie);// to remove movies
        }
        if(directorMap.containsKey(directorName))
            directorMap.remove(directorName);// to remove director
        pairMap.remove(directorName);// to remove director& movies pair
    }
    public void deleteAllDirectors(){
        List<String> movies=new ArrayList<>();
        for(String directorName: pairMap.keySet()){
              movies=pairMap.get(directorName);
              for(String movie:movies){
                  if(movieMap.containsKey(movie))
                      movieMap.remove(movie);
              }
              if(directorMap.containsKey(directorName))
                   directorMap.remove(directorName);
        }
        pairMap.clear();
    }

}
