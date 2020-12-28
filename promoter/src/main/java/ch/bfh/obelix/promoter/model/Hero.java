package ch.bfh.obelix.promoter.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class Hero extends RepresentationModel {

  private String id;

  private String name;
  private int atk;
  private int def;
  private double hp;

}
