package ch.bfh.obelix.promoter;

import ch.bfh.obelix.promoter.service.PromoterService;
import ch.bfh.obelix.promoter.service.impl.PromoterServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class PromoterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromoterApplication.class, args);
	}

	@Bean
	public PromoterService promoterService() {
		return new PromoterServiceImpl();
	}


}
