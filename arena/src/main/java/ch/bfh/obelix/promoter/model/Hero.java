package ch.bfh.obelix.promoter.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Hero extends RepresentationModel {

  private String id;

  private String name;
  private int atk;
  private int def;
  private double hp;

}
