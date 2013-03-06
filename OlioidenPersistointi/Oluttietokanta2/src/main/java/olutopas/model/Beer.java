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
    private Integer id;

    @ManyToOne
    Brewery brewery;

    // mapped by tarkoittaa että tämä ei Beer:in tallettava taulu _ei_ ole omistava puoli
    @ManyToMany(mappedBy = "beers", cascade = CascadeType.ALL)
    List<Pub> pubs;

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

    public void setPubs(List<Pub> pubs) {
        this.pubs = pubs;
    }

    public List<Pub> getPubs() {
        return pubs;
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

    public void addToPubs(Pub pub) {
        if ( pubs==null  ) pubs = new ArrayList<Pub>();
        pubs.add(pub);
    }

    public void removePub(Pub pub) {
        pubs.remove(pub);
    }
    
}
