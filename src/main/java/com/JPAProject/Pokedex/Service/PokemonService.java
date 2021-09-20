package com.JPAProject.Pokedex.Service;

import com.JPAProject.Pokedex.DTO.PokemonDTO;
import com.JPAProject.Pokedex.Dao.PokemonDAO_WithCriteriaBuilder;
import com.JPAProject.Pokedex.Dao.PokemonRepository;
import com.JPAProject.Pokedex.Entity.Pokemon;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PokemonDAO_WithCriteriaBuilder pokeDAO;

    /*public Page<PokemonDTO> getAllPokemon(Pageable pageable) {

        Page<PokemonDTO> dtoPage = pokemonRepository.findAll(pageable).map(pokemon -> modelMapper.map(pokemon,PokemonDTO.class));
        return dtoPage;
    }*/

    public List<PokemonDTO> findAll(){

        List<PokemonDTO> pokeDTO = pokeDAO.findAll()
                                         .stream()
                                         .map(pokemon -> modelMapper.map(pokemon,PokemonDTO  .class)).collect(Collectors.toList());
        return pokeDTO;
    }

    private PokemonDTO convertToDto(Pokemon pokemon) {
        PokemonDTO pokeDTO = modelMapper.map(pokemon, PokemonDTO.class);

        return pokeDTO;
    }

    public PokemonDTO getPokemonById(Integer id) {

        PokemonDTO pokemon = convertToDto(pokeDAO.findById(id));
        return pokemon;

    }

   /* public String getNameById(Integer id){

        return pokemonRepository.findNameById(id);
    }*/


}

