package com.JPAProject.Pokedex.DTO;


import com.JPAProject.Pokedex.Entity.Pokemon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
@NoArgsConstructor
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
