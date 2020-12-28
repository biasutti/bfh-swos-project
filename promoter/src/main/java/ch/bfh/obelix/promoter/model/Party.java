package ch.bfh.obelix.promoter.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class Party extends RepresentationModel {

    private String name;
    private List<Hero> members;

}
