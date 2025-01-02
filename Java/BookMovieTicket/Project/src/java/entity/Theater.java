/*
 * Entity that lets you access the theather table
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ikhad
 */
@Entity
@Table(name = "THEATER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t"),
    @NamedQuery(name = "Theater.findByZipcodeValue", query = "SELECT t FROM Theater t WHERE t.zipcodeValue = :zipcodeValue"), //used to get the theater value based on the zipcode
    @NamedQuery(name = "Theater.findByTheaterId", query = "SELECT m FROM Movie m,Shownat s WHERE s.movieId= m.movieId and s.theaterId = :theaterId")}) // used to get the theater values based on theater id

public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    
    private Integer theaterId; //variables
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String theaterName;

    
    private Integer zipcodeValue;
    //constructors
    public Theater() {
    }

    public Theater(Integer theaterid) {
        this.theaterId = theaterid;
    }

    public Theater(Integer theaterid, String theatername) {
        this.theaterId = theaterid;
        this.theaterName = theatername;
    }
    //getter and setter
    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterid) {
        this.theaterId = theaterid;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    
 

    public Integer getZipcodeValue() {
        return zipcodeValue;
    }

    public void setZipcodeValue(Integer zipcodeValue) {
        this.zipcodeValue = zipcodeValue;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterId != null ? theaterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.theaterId == null && other.theaterId != null) || (this.theaterId != null && !this.theaterId.equals(other.theaterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theater[ theaterid=" + theaterId + " ]";
    }
    
}