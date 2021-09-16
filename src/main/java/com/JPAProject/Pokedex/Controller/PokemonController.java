package com.JPAProject.Pokedex.Controller;

import com.JPAProject.Pokedex.DTO.PokemonDTO;
import com.JPAProject.Pokedex.Entity.Pokemon;
import com.JPAProject.Pokedex.Service.PokemonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pokedex")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private ModelMapper modelMapper;

  /*  @Autowired
    private PokemonService pokemonService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pokemon> getAllPokemon() {

        return pokemonService.getAllPokemon();
    }*/

    @GetMapping// Same as RequestMapping(method = method.GET)
                //PageableDefault really good manner of set the default for pagination.
    public Page<Pokemon> listAllPokemonPageable(@PageableDefault(sort = "id", direction = Sort.Direction.ASC,
            size = 7) Pageable pageable) {

        return pokemonService.getAllPokemon((pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PokemonDTO getPokemonById(@PathVariable("id") Integer id) {

        return pokemonService.getPokemonById(id);
    }


    @GetMapping("/{id}/name")
    @ResponseBody
    public String getPokemonName(@PathVariable("id") Integer id){

        return pokemonService.getNameById(id);
    }


}
