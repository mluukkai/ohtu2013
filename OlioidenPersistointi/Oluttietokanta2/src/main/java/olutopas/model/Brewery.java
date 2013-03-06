package olutopas.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brewery {

    private String name;
    
    @Id
    private Integer id;
        
    @OneToMany(cascade = CascadeType.ALL)
    private List<Beer> beers;

    public Brewery() {
    }    
    
    public Brewery(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> biers) {
        this.beers = biers;
    }

    @Override
    public String toString() {
        return getName() + ", beers: " + getBeers().size();
    }

    public void addBeer(Beer b) {
        if (beers == null) {
            beers = new ArrayList<Beer>();
        }
    
        beers.add(b);
        b.setBrewery(this);
    }
}
