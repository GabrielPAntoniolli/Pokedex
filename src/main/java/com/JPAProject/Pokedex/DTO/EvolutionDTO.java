package com.JPAProject.Pokedex.DTO;

import com.JPAProject.Pokedex.Entity.Pokemon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EvolutionDTO {

    private Integer id;
    private String name;
    private Integer weight;
    private String type;
}
