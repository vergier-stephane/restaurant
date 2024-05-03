package manageo.restaurant.web.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import manageo.restaurant.persistence.entities.RestaurantEntity;
import manageo.restaurant.web.dto.RestaurantDto;

public class RestaurantConverter {
    
    public RestaurantDto convert( RestaurantEntity entity ) {
        RestaurantDto dto = new RestaurantDto();
        dto.setId(entity.getId());
        dto.setPlaces(entity.getPlaces());
        return dto;
    }

    public RestaurantEntity convert( RestaurantDto dto ) {
        RestaurantEntity entity = new RestaurantEntity();
        entity.setId(dto.getId());
        entity.setPlaces(dto.getPlaces());
        return entity;
    }

    public Page<RestaurantDto> convert( Page<RestaurantEntity> entities ) {
        List<RestaurantDto> dtos = new ArrayList<RestaurantDto>();
        entities.forEach( entity -> {
            dtos.add( this.convert(entity) );
        });
        Page<RestaurantDto> page = new PageImpl<RestaurantDto>( dtos , PageRequest.of( entities.getNumber() , entities.getSize() ) , entities.getTotalElements() );
        return page;
    }

}
