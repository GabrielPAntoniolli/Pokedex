package com.JPAProject.Pokedex.DTO;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@ToString
public class PokemonDTO {


    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;
    private Integer health_points;
    private Integer attack;
    private Integer defense;
    private Integer special_attack;
    private Integer special_defense;
    private Integer speed;
    private String front_sprite;
    private String back_sprite;
    private String type;
    private List<String> move;
    private List<EvolutionDTO> evolve_to;



}
