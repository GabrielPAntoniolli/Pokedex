package com.JPAProject.Pokedex.DTO;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PokemonDTO {

    private Integer id;
    private String name;
    private Integer weight;
    private List<EvolutionDTO> evolve_to;
    private List<String> move;


}
