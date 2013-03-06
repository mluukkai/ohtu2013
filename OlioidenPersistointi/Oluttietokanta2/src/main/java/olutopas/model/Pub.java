package olutopas.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pub {
    private String name;
    
    @Id
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Beer> beers;
    
    public Pub() {
    }

    public Pub(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }   
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }   
    
    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void addBeer(Beer beer) {
        if ( beers==null) beers= new ArrayList<Beer>();
        
        beers.add(beer);
    }
    
    @Override
    public String toString() {
        return name +", beers available "+beers.size();
    }           

    public void removeBeer(Beer beer) {
        beers.remove(beer);        
    } 

    @Override
    public boolean equals(Object o) {
        Pub other = (Pub)o;
        return getId() == other.getId();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
                 
}
