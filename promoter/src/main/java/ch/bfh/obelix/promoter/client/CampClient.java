package ch.bfh.obelix.promoter.client;

import ch.bfh.obelix.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "camp-service")
public interface CampClient {

  @GetMapping("/createParty")
  EntityModel<Party> createParty(@RequestParam(value = "name") String name);

}
