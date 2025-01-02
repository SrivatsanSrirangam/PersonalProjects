/*
 * Entity that lets you access the Movie table
 */
package entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ikhad
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieid", query = "SELECT m FROM Movie m WHERE m.movieId = :movieId"), 
    @NamedQuery(name = "Movie.findByMoviename", query = "SELECT m FROM Movie m WHERE m.movieName = :movieName"), //used to get the movie names 
    @NamedQuery(name = "Movie.findByDescription", query = "SELECT m FROM Movie m WHERE m.description = :description"), //used to get description from the movie
    @NamedQuery(name = "Movie.findByTheaterId", query = "SELECT m FROM Movie m,Shownat s WHERE s.movieId= m.movieId and s.theaterId = :theaterId"), //used to get movies from theater id
    @NamedQuery(name = "Movie.findByDuration", query = "SELECT m FROM Movie m WHERE m.duration = :duration")}) //used to get the movie duration
    
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
    private Integer movieId; //variables in the table
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    
    private String movieName;
    @Size(max = 1000)
   
    private String description;
    
    @Size(min = 1, max = 7)
    private String duration;

    //constuctors
    public Movie() {
    }

    public Movie(Integer movieId) {
        this.movieId = movieId;
    }

    public Movie(Integer movieid, String movieName) {
        this.movieId = movieid;
        this.movieName = movieName;
    }
    //getter and setters
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.movieId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.movieId, other.movieId)) {
            return false;
        }
        return true;
    }

    
    
    

    



}