/*
 * Entity that lets you access the shownat table
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ikhad
 */
@Entity
@Table(name = "SHOWNAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shownat.findAll", query = "SELECT s FROM Shownat s"),
    @NamedQuery(name = "Shownat.findByShownatId", query = "SELECT s FROM Shownat s WHERE s.shownatId = :shownatId")}) //lets you access the values based on shownatID
public class Shownat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    
    private Integer shownatId; //column names
    
    
    private Integer movieId;
    
    
    private Integer theaterId;
    
    //constructors
    public Shownat() {
    }
    
    public Shownat(Integer shownatId) {
        this.shownatId = shownatId;
    }
    //getters and setters
    public Integer getShownatId() {
        return shownatId;
    }

    public void setShownatId(Integer shownatId) {
        this.shownatId = shownatId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    

    
 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shownatId != null ? shownatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shownat)) {
            return false;
        }
        Shownat other = (Shownat) object;
        if ((this.shownatId == null && other.shownatId != null) || (this.shownatId != null && !this.shownatId.equals(other.shownatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shownat[ shownatId=" + shownatId + " ]";
    }
    
}