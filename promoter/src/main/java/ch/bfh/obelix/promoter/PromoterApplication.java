package ch.bfh.obelix.promoter;

import ch.bfh.obelix.promoter.client.ArenaClient;
import ch.bfh.obelix.promoter.client.CampClient;
import ch.bfh.obelix.promoter.client.impl.ArenaClientImpl;
import ch.bfh.obelix.promoter.client.impl.CampClientImpl;
import ch.bfh.obelix.promoter.service.PromoterService;
import ch.bfh.obelix.promoter.service.impl.PromoterServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PromoterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromoterApplication.class, args);
	}

	@Bean
	public PromoterService promoterService() {
		return new PromoterServiceImpl();
	}

	@Bean
	public ArenaClient arenaClient() {
		return new ArenaClientImpl();
	}

	@Bean
	public CampClient campClient() {
		return new CampClientImpl();
	}

}
