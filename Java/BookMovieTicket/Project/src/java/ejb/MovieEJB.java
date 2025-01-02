/*
 * This ejb lets you work with the entities to access the database
 */
package ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entity.Zipcode;
import entity.Theater;
import entity.Shownattimes;
import entity.Movie;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ikhad
 */
@Stateful
public class MovieEJB {

    
    @PersistenceContext(unitName = "ProjectPU")
    EntityManager em;
    public void persist(Object object) { //saves the items from the database
        em.persist(object);
    }
    public List<Zipcode> findAllZipcode() //lets you get all the zipcodes
    {
        return em.createNamedQuery("Zipcode.findAll", Zipcode.class).getResultList(); 
    }
    public List<Theater> getTheatersFromZipcode(int zipcodeValue) //lets you get all the theaters based on the zipcodes
    {
        return em.createNamedQuery("Theater.findByZipcodeValue", Theater.class).setParameter("zipcodeValue", zipcodeValue).getResultList(); 
    }
    
    public List<Movie> getMoviesFromTheaterId(int  theaterId) //lets you get all the movies based on the theaters
    {
        return em.createNamedQuery("Movie.findByTheaterId", Movie.class).setParameter("theaterId", theaterId).getResultList(); 
    }
     public List<Shownattimes> getTimesFromMovieId(int  movieId) // lets you get the show times from the movieid
    {
        return em.createNamedQuery("Shownattimes.findByMovieId", Shownattimes.class).setParameter("movieId", movieId).getResultList(); 
    }

    
}