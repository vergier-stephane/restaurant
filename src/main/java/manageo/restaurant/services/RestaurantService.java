package manageo.restaurant.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import manageo.restaurant.persistence.entities.RestaurantEntity;
import manageo.restaurant.persistence.repositories.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository repository;

    public Page<RestaurantEntity> listRestaurants( Pageable page ) {
        return repository.findAll( page );
    }

    public Optional<RestaurantEntity> findRestaurant( Long id ) {
        return repository.findById(id);
    }

}
