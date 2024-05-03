package manageo.restaurant.web.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import manageo.restaurant.persistence.entities.RestaurantEntity;
import manageo.restaurant.web.dto.RestaurantDto;

public class ReservationConverterTests {
    
    RestaurantConverter converter = new RestaurantConverter();

    void checkDtoAndEntityAreEqual( RestaurantDto dto , RestaurantEntity entity ) {
        assertEquals( dto.getId() , entity.getId() );
        assertEquals( dto.getPlaces() , entity.getPlaces() );
    }

    @Test
    void testConvertDtoToEntity() {
        RestaurantDto dto = new RestaurantDto();
        dto.setId(1);
        dto.setPlaces(10);
        RestaurantEntity entity = converter.convert(dto);
        this.checkDtoAndEntityAreEqual(dto, entity);
    }

    @Test
    void testConvertEntityToDto() {
        RestaurantEntity entity = new RestaurantEntity();
        entity.setId(1);
        entity.setPlaces(10);
        RestaurantDto dto = converter.convert(entity);
        this.checkDtoAndEntityAreEqual(dto, entity);
    }

    @Test
    void testConvertPageEntitytoPageDto() {
        List<RestaurantEntity> list = new ArrayList<>();
        RestaurantEntity entity = new RestaurantEntity();
        entity.setId(1);
        entity.setPlaces(10);
        list.add(entity);
        Page<RestaurantEntity> page = new PageImpl<>( list , PageRequest.of( 0 , 10 ) , 1000 );
        Page<RestaurantDto> result = converter.convert(page);
        assertEquals( page.getSize() , result.getSize() );
        assertEquals( page.getTotalPages(), page.getTotalPages());
        assertEquals( page.getTotalElements(), page.getTotalElements());
    }

}
