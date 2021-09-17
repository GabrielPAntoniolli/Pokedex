package com.JPAProject.Pokedex.Dao;


import com.JPAProject.Pokedex.Entity.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PokemonDAO_WithCriteriaBuilder {


    private final EntityManager entityManager;

    public List<Pokemon> findAll() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pokemon> criteriaQuery = criteriaBuilder.createQuery(Pokemon.class);
        Root<Pokemon> pokemonRoot = criteriaQuery.from(Pokemon.class);
        criteriaQuery.select(pokemonRoot);
        TypedQuery<Pokemon> typedQuery = entityManager.createQuery(criteriaQuery);
        List<Pokemon> allPokemon = typedQuery.getResultList();

        return allPokemon;
    }

}
