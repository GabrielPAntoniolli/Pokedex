package com.JPAProject.Pokedex.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Getter
@ToString
@Setter
@Entity(name = "Pokemon")
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @Column(name = "pokemon_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "height")
    private Integer height;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "health_points")
    private Integer health_points;
    @Column(name = "attack")
    private Integer attack;
    @Column(name = "defense")
    private Integer defense;
    @Column(name = "special_attack")
    private Integer special_attack;
    @Column(name = "special_defense")
    private Integer special_defense;
    @Column(name = "speed")
    private Integer speed;
    @Column(name = "front_sprite")
    private Integer front_sprite;
    @Column(name = "back_sprite")
    private Integer back_sprite;
    @Column(name = "type")
    private String type;



    @ElementCollection
    @Column(name = "move")
    @CollectionTable(
            name = "move",
            joinColumns = @JoinColumn(name = "pokemon_id"))

    Set<String> move;

    @ManyToMany
    @JoinTable(
            name = "evolution",
            joinColumns = @JoinColumn(name="pokemon_id"),
    inverseJoinColumns = @JoinColumn(name = "evolve_to"))

    private Set<Pokemon> evolve_to;
}