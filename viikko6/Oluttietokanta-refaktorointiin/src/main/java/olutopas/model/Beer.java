package olutopas.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Beer {

    private String name;
    @Id
    Integer id;

    @ManyToOne
    Brewery brewery;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
    
    @OneToMany(cascade= CascadeType.ALL)
    private List<Rating> ratings;
    
    public Beer() {
    }   
    
    public Beer(String name) {
        this.name = name;
    }        
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    } 

    @Override
    public boolean equals(Object o) {
        Beer other = (Beer)o;
        
        return id == other.getId();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }       
    
    @Override
    public String toString() {
        return getName() + " ("+getBrewery().getName()+")";
    }     
    
    public double averageRating(){
        double sum = 0;
        
        for (Rating r : getRatings()) {
            sum += r.getPoints();
        }
        
        return sum / getRatings().size();
    }
}
