package com.JPAProject.Pokedex.Dao;


import com.JPAProject.Pokedex.DTO.PokemonDTO;
import com.JPAProject.Pokedex.Entity.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    Optional<Pokemon> findById(Integer id);
    Page<Pokemon> findAll(Pageable pageable);

    @Query("select name from Pokemon where id = ?1")
    String findNameById(Integer id);


    Optional<Pokemon> findByName(String name);


}
