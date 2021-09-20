package com.JPAProject.Pokedex.Service;

import com.JPAProject.Pokedex.DTO.PokemonDTO;
import com.JPAProject.Pokedex.Dao.PokemonRepository;
import com.JPAProject.Pokedex.Entity.Pokemon;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PokemonRepository pokemonRepository;

    public Page<PokemonDTO> getAllPokemon(Pageable pageable) {
    Page<PokemonDTO> pokeDTO = pokemonRepository.findAll(pageable).map(pokemon -> modelMapper.map(pokemon,PokemonDTO.class));

        return pokeDTO;
    }


    private PokemonDTO convertToDto(Pokemon pokemon) {
        PokemonDTO pokeDTO = modelMapper.map(pokemon, PokemonDTO.class);

        return pokeDTO;
    }

    public PokemonDTO getPokemonById(Integer id) {

        PokemonDTO pokemon = convertToDto(pokemonRepository.findById(id).orElseThrow(RuntimeException::new));
        return pokemon;
    }

    public String getNameById(Integer id){

        return pokemonRepository.findNameById(id);
    }


}

