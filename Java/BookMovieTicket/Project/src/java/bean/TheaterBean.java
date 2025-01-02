/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.MovieEJB;
import entity.Movie;
import entity.Theater;
import entity.Zipcode;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.*;

/**
 *
 * @author srivatsansrirangam
 */
@Named(value = "theaterBean")
@ApplicationScoped
public class TheaterBean {
    @EJB
    private MovieEJB movieEJB;
    private Theater theater;
    private Zipcode zipcode;
    /**
     * Creates a new instance of TheaterBean
     */
    public TheaterBean() {
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

    public Zipcode getZipcode() {
        return zipcode;
    }

    public void setZipcode(Zipcode zipcode) {
        this.zipcode = zipcode;
    }
    
    
    
    public String selectZipcode(Zipcode zipcode) {
        this.zipcode = zipcode;
        return "TheatersForZipcode.xhtml";
    }

    
    public List<Theater> getTheatersForZipcode()
    {
        if (zipcode != null)
           return movieEJB.getTheatersFromZipcode(zipcode.getZipcodeValue());
        else
            return null;
    }
    

}
