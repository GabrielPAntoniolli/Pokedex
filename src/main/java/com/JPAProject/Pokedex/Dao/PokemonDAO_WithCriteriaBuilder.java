package com.JPAProject.Pokedex.Dao;


import com.JPAProject.Pokedex.Entity.Pokemon;
import com.JPAProject.Pokedex.Entity.Pokemon_;
import lombok.RequiredArgsConstructor;
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

    public Pokemon findById(Integer id){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pokemon> criteriaQuery = cb.createQuery(Pokemon.class);
        Root<Pokemon> pokeRoot = criteriaQuery.from(Pokemon.class);
        criteriaQuery.select(pokeRoot).where(cb.equal(pokeRoot.get(Pokemon_.id), id));
        return entityManager.createQuery(criteriaQuery).getSingleResult();

    }

}
