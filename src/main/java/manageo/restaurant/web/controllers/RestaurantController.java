package manageo.restaurant.web.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import manageo.restaurant.web.converters.RestaurantConverter;
import manageo.restaurant.web.dto.ReservationDto;
import manageo.restaurant.web.dto.RestaurantDto;
import manageo.restaurant.persistence.entities.RestaurantEntity;
import manageo.restaurant.services.RestaurantService;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService service;

    RestaurantConverter converter = new RestaurantConverter();

    @GetMapping( path="/")
    ResponseEntity<Page<RestaurantDto>> listRestaurants(@RequestParam(required = false, defaultValue="0") Integer page, 
                        @RequestParam(required = false, defaultValue = "10" ) Integer size ) {
        Page<RestaurantEntity> pageEntity = service.listRestaurants( PageRequest.of(page, size) );
        System.out.println("nb restaurants: " + pageEntity.getNumberOfElements());
        return ResponseEntity.ok().body( converter.convert(pageEntity) );
    }

    @GetMapping( path="/detail/{id}")
    ResponseEntity<RestaurantDto> getRestaurant(@PathVariable(name = "id" ) Long id ) {
        System.out.println("Process detail restaurant");
        Optional<RestaurantEntity> entity = service.findRestaurant(id);
        System.out.println("restaurant: " + entity );
        if( entity.isPresent() ) {
            return ResponseEntity.ok().body( converter.convert(entity.get()) );
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping( path="/availability")
    ResponseEntity<Boolean> isRestaurantAvailable(@RequestBody ReservationDto reservation ) {
        return ResponseEntity.ok().body(true);
    }

}
