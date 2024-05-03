package manageo.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import manageo.restaurant.persistence.entities.RestaurantEntity;
import manageo.restaurant.persistence.repositories.RestaurantRepository;

@SpringBootTest
class RestaurantApplicationTests {

	@Autowired
	RestaurantRepository repo;

	@Test
	void contextLoads() {
		
		RestaurantEntity entity = new RestaurantEntity();
		entity.setPlaces(50);

		RestaurantEntity saved = repo.save(entity);
		System.out.println( "Saved: " + saved.getId() );

		System.out.println("nb elements in repo: " + repo.count() );

		Page<RestaurantEntity> page = repo.findAll( PageRequest.of( 0 , 10 ) );
		System.out.println( "Page: " + page.getNumberOfElements() );
	}

}
