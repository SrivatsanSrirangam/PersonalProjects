/*
 * This entity is used to access the shownattimes table
 */
package entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ikhad
 */
@Entity
@Table(name = "SHOWNATTIMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shownattimes.findAll", query = "SELECT s FROM Shownattimes s"),
    @NamedQuery(name = "Shownattimes.findByShownatid", query = "SELECT s FROM Shownattimes s WHERE s.shownattimesPK.shownatId = :shownatId"),
    @NamedQuery(name = "Shownattimes.findByMovieId", query = "SELECT s FROM Shownattimes s,Shownat a WHERE a.movieId=:movieId and s.shownattimesPK.shownatId = a.shownatId"), //this is used to find the movie show times by using the shownid. 
    @NamedQuery(name = "Shownattimes.findByShowtime", query = "SELECT s FROM Shownattimes s WHERE s.shownattimesPK.showTime = :showTime")})

public class Shownattimes implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ShownattimesPK shownattimesPK;
    
    
    //constructors
    public Shownattimes() {
    }

    public Shownattimes(ShownattimesPK shownattimesPK) {
        this.shownattimesPK = shownattimesPK;
    }

    public Shownattimes(int shownatid, String showTime) {
        this.shownattimesPK = new ShownattimesPK(shownatid, showTime);
    }
    //setters and getters
    public ShownattimesPK getShownattimesPK() {
        return shownattimesPK;
    }

    public void setShownattimesPK(ShownattimesPK shownattimesPK) {
        this.shownattimesPK = shownattimesPK;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shownattimesPK != null ? shownattimesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shownattimes)) {
            return false;
        }
        Shownattimes other = (Shownattimes) object;
        if ((this.shownattimesPK == null && other.shownattimesPK != null) || (this.shownattimesPK != null && !this.shownattimesPK.equals(other.shownattimesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shownattimes[ shownattimesPK=" + shownattimesPK + " ]";
    }
    
}