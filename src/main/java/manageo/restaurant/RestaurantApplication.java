package manageo.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import manageo.restaurant.persistence.repositories.RestaurantRepository;

@SpringBootApplication
public class RestaurantApplication {

	@Autowired
	RestaurantRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

}
