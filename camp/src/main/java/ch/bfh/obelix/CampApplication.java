package ch.bfh.obelix;

import ch.bfh.obelix.camp.service.HeroService;
import ch.bfh.obelix.camp.service.PartyService;
import ch.bfh.obelix.camp.service.impl.HeroServiceImpl;
import ch.bfh.obelix.camp.service.impl.PartyServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CampApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampApplication.class, args);
	}

	@Bean
	public HeroService heroService() {
		return new HeroServiceImpl();
	}

	@Bean
	public PartyService partyService() {
		return new PartyServiceImpl();
	}

}
