package ch.bfh.obelix.arena;

import ch.bfh.obelix.arena.service.BattleService;
import ch.bfh.obelix.arena.service.impl.BattleServiceImpl;
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
