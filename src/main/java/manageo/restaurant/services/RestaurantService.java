package manageo.restaurant.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import manageo.restaurant.persistence.entities.RestaurantEntity;
import manageo.restaurant.persistence.repositories.RestaurantRepository;

/**
 * The restaurant Data Access service 
 */
@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repository;

    /*
     * List restaurants, returns a page of data
     */
    public Page<RestaurantEntity> listRestaurants( Pageable page ) {
        return repository.findAll( page );
    }

    /*
     * Finds a restaurant by its id
     */
    public Optional<RestaurantEntity> findRestaurant( Long id ) {
        return repository.findById(id);
    }

}
