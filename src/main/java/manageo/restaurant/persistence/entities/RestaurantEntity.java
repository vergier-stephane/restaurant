package manageo.restaurant.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table( name = "RESTAURANT")
public class RestaurantEntity {
    
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    long id;

    int places;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPlaces() {
        return places;
    }
    
    public void setPlaces(int places) {
        this.places = places;
    }

}
