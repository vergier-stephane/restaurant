package manageo.restaurant.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import manageo.restaurant.persistence.entities.RestaurantEntity;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Long> {
    
}
