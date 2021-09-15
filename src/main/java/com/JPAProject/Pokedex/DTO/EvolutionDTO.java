package com.JPAProject.Pokedex.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EvolutionDTO {

    private Integer id;
    private String name;
    private Integer weight;
    private String type;
}
