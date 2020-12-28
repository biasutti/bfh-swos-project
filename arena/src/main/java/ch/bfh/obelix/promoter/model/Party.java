package ch.bfh.obelix.promoter.model;

import lombok.Data;

import java.util.List;

@Data
public class Party  {

    private String name;
    private List<Hero> members;

}
