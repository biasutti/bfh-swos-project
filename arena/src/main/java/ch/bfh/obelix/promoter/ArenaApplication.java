package ch.bfh.obelix.promoter;

import ch.bfh.obelix.promoter.service.BattleService;
import ch.bfh.obelix.promoter.service.impl.BattleServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArenaApplication.class, args);
	}

	@Bean
	public BattleService battleService() {
		return new BattleServiceImpl();
	}

}
