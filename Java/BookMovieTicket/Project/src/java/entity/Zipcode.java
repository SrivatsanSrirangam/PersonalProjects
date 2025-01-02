/*
 * Entity that lets you access the zipcode information
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zipcode.findAll", query = "SELECT z FROM Zipcode z"), //gets all the zipcodes
    @NamedQuery(name = "Zipcode.findByZipcodevalue", query = "SELECT z FROM Zipcode z WHERE z.zipcodeValue = :zipcodeValue")}) //gets the zipcode based on the zipvalue
public class Zipcode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    
    private Integer zipcodeValue; //variable
    
    //constuctors
    public Zipcode() {
    }

    public Zipcode(Integer zipcodeValue) {
        this.zipcodeValue = zipcodeValue;
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
        hash += (zipcodeValue != null ? zipcodeValue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zipcode)) {
            return false;
        }
        Zipcode other = (Zipcode) object;
        if ((this.zipcodeValue == null && other.zipcodeValue != null) || (this.zipcodeValue != null && !this.zipcodeValue.equals(other.zipcodeValue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Zipcode[ zipcodevalue=" + zipcodeValue + " ]";
    }
    
}