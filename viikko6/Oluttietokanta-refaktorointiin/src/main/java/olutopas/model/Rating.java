package olutopas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
    @Id
    Integer id;

    @ManyToOne
    Beer beer;

    @ManyToOne
    User user;

    public Rating() {
    }   
    
    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    private int points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Rating( Beer beer, User user, int points) {
        this.beer = beer;
        this.user = user;
        this.points = points;
    }    

    @Override
    public String toString() {
        return getBeer() + " "+points+" points";
    }
        
}
