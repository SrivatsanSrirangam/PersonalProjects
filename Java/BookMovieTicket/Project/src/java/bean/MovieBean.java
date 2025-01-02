/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.MovieEJB;
import entity.Movie;
import entity.Shownattimes;
import entity.Theater;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.*;

/**
 *
 * @author srivatsansrirangam
 */
@Named(value = "movieBean")
@ApplicationScoped
public class MovieBean {
     @EJB
    private MovieEJB movieEJB;
    private Theater theater;
    private Movie movie;
    /**
     * Creates a new instance of MovieBean
     */
    public MovieBean() {
    }

    public MovieEJB getMovieEJB() {
        return movieEJB;
    }

    public void setMovieEJB(MovieEJB movieEJB) {
        this.movieEJB = movieEJB;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    
    public String selectTheater(Theater theater) {
        this.theater = theater;
        return "MoviesForTheater.xhtml";
    }
    
    public List<Movie> getMoviesForTheater() {
    
        if (theater != null) {
           
            
            return movieEJB.getMoviesFromTheaterId(theater.getTheaterId());
        }
        else
            return null;
    }
        
    public String selectMovieShowDescription(Movie movie) {
        this.movie = movie;
        return "MovieDescription.xhtml";
    }
    
    public String selectMovieShowTimes(Movie movie) {
        this.movie = movie;
        return "TimesForMovie.xhtml";
    }
    
    public List<Shownattimes> getTimesForMovie() {
    
        if (theater != null) {
           return movieEJB.getTimesFromMovieId(movie.getMovieId());
        }
        else
            return null;
    }
    
    
    
    
}
