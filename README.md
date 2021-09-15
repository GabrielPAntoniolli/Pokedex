# Pokedex

This projects mimics a PokeDex backed by PokeApi.co data.

Technologies used:
SpringBoot Web
Lombok
ModelMapper
Hibernate/JPA
MySQL
Python Scripts to fetch PokeApi data




Endpoints
v1/pokedex/{id} -> Returns PokeData, containing id, name, weight, height, stats, base64 encrypted sprites, evolutions and types. v1/pokedex/? -> Returns a pagination of Pokemon, containing ID and name. Query parameters(name, pageNumber, pageSize and sortBy).
