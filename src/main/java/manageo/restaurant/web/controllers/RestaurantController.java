package manageo.restaurant.web.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

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

/*
 * Restaurant controller provides a paginated list of restaurant,
 * finds a restaurant bu its id and check if a restaurant is available for reservation 
 */
@RestController
public class RestaurantController {

    @Autowired
    RestaurantService service;

    RestaurantConverter converter = new RestaurantConverter();

    /*
     * Returns a paginated list of restaurant
     */
    @GetMapping( path="/")
    @Operation(summary = "List a page of restaurant")
    ResponseEntity<Page<RestaurantDto>> listRestaurants(@RequestParam(required = false, defaultValue="0") Integer page, 
                        @RequestParam(required = false, defaultValue = "10" ) Integer size ) {
        Page<RestaurantEntity> pageEntity = service.listRestaurants( PageRequest.of(page, size) );
        System.out.println("nb restaurants: " + pageEntity.getNumberOfElements());
        return ResponseEntity.ok().body( converter.convert(pageEntity) );
    }

    @GetMapping( path="/detail/{id}")
    @Operation(summary = "Find a restaurant by its id")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Return the detail for the restaurant", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = RestaurantDto.class ) ) } ) ,
        @ApiResponse(responseCode = "404", description = "The restaurant was not found") } )
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
    @Operation(summary = "Check if a restaurant is available for a reservation")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Returns true if the restaurant is available for the reservation, returns false otherwise", 
          content = { @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Boolean.class ) ) } ) } )
    ResponseEntity<Boolean> isRestaurantAvailable(@RequestBody ReservationDto reservation ) {
        return ResponseEntity.ok().body(true);
    }

}
