/*package com.JPAProject.First.Dao;

import com.JPAProject.First.Entity.Evolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvolutionRepository extends JpaRepository<Evolution,Integer> {

    Optional<Evolution> findById(Integer id); // return all chain

    @Query("select come_from_id from Evolution where id = ?1")
    Integer findPreEvoById(Integer id);

    @Query("select evolve_to_id from Evolution where id = ?1")
    Integer findNextEvoById(Integer id);


}*/
