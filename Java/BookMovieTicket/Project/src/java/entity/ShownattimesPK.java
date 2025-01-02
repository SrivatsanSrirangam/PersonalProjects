/*
 * This class is simply used to create a primary key based on the two values on shownattimes
 */
package entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ikhad
 */
@Embeddable
public class ShownattimesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
   
    private Integer shownatId;
    @Basic(optional = false)
    @NotNull
    
    @Size(min = 1, max = 8)
    private String showTime;
    //constructors
    public ShownattimesPK() {
    }

    public ShownattimesPK(int shownatId, String showTime) { 
        this.shownatId = shownatId;
        this.showTime = showTime;
    }
    //setters and getters
    public Integer getShownatId() {
        return shownatId;
    }

    public void setShownatId(Integer shownatId) {
        this.shownatId = shownatId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.shownatId);
        hash = 17 * hash + Objects.hashCode(this.showTime);
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
        final ShownattimesPK other = (ShownattimesPK) obj;
        if (!Objects.equals(this.showTime, other.showTime)) {
            return false;
        }
        if (!Objects.equals(this.shownatId, other.shownatId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShownattimesPK{" + "shownatId=" + shownatId + ", showTime=" + showTime + '}';
    }
    
    
}