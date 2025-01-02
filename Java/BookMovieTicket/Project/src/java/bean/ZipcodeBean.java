/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.MovieEJB;
import entity.Theater;
import entity.Zipcode;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.*;
import javax.faces.context.FacesContext;

/**
 *
 * @author srivatsansrirangam
 */
@Named(value = "zipcodeBean")
@ApplicationScoped
public class ZipcodeBean{
    @EJB
    private MovieEJB movieEJB;
    private Zipcode zipcode;

    public MovieEJB getMovieEJB() {
        return movieEJB;
    }

    public void setMovieEJB(MovieEJB movieEJB) {
        this.movieEJB = movieEJB;
    }

    public Zipcode getZipcode() {
        return zipcode;
    }

    public void setZipcode(Zipcode zipcode) {
        this.zipcode = zipcode;
    }
    
    
    /**
     * Creates a new instance of ZipCodeBean
     */
    public ZipcodeBean() {
        
    }
    
    public List<Zipcode> getZipcodeList()
    {
        return movieEJB.findAllZipcode();
    }
    

    
}
