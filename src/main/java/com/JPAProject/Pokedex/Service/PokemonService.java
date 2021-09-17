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

    public List<Pokemon> findAll(){

        return pokeDAO.findAll();
    }

    private PokemonDTO convertToDto(Pokemon pokemon) {
        PokemonDTO pokeDTO = modelMapper.map(pokemon, PokemonDTO.class);

        return pokeDTO;
    }

    /*public PokemonDTO getPokemonById(Integer id) {

        PokemonDTO pokemon = convertToDto(pokemonRepository.findById(id).orElseThrow(RuntimeException::new));
        return pokemon;
    }*/

   /* public String getNameById(Integer id){

        return pokemonRepository.findNameById(id);
    }*/


}

