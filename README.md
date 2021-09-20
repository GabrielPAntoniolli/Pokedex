# ***Pokedex***

## **What is a Pokedex**?
It is a Pokémon Encyclopedia,  designed to catalogue and provide information regarding the various species of Pokémon.

*This projects mimics a PokeDex backed by https://pokeapi.co/ data.*

## ***Technologies used:***
* SpringBoot Web
* Lombok
* ModelMapper
* Hibernate/JPA
* MySQL
* Python Scripts to fetch PokeApi data

## ***Steps:***

### 1. ***Fetching API*** 
  The First step was to acess the relevant data from PokeApi.co, which is a JSON format, and take the information I needed. to make sure of dealing with data that had differences between each pokemon. 
    For example with pokemon number 133 (Eevee), it has 7 evolutions, while the majority of pokemon has only 2, some 1, and some doesn't even have any evolution, then the way of dealing with each pokemon evolution is different. 
  I chose to use python as the data accessor, because I had some previous experience with the "Requests" library, and also I consider python a more straight-forward oriented language, perfect for small micro-services as this one.

![image](https://user-images.githubusercontent.com/72032836/133973878-478aff50-0157-4fd3-9850-3a0031b72b47.png)

### 2. ***Generate SQL Queries*** 
The main goal for fetching the https://pokeapi.co/ was to save all the data I considered relevant in my own database, so I would have access it all the time to run my program.
After making all the functions with all data I wanted, I decided to generate sql lines of code, so all data could be inserted in the database, in my case, MySQL.

Script of the SQL queries:

![image](https://user-images.githubusercontent.com/72032836/133974706-2267aa71-5121-4370-9ab9-6a97849c9ea1.png)

### 3. ***Inserting into Database***
Having all the queries, all I had to do was copying all of them, paste it in the database and run it, so I could build the tables.
The issue here, was that I not only had to do a main table "pokemon", but also some relevant information comes in a list format, such as: skills and evolutions of every pokemon, so tables had to be made to validate this. And then do the appropriate relationship between tables, in this cases "Many-to-Many".

### 4. ***Mapping Entities with tables using Hibernate***
Hibernate has a very straight-forward way of mapping the entities to database's tables. Basically, every field of the entity is mapped to a column of the table, and the Primary Key must be indicated with the Annotation @Id, if the field has a different name from the column the annotation @Column(name = "name-of-column") can be used to do the appropriated link.

![image](https://user-images.githubusercontent.com/72032836/133976123-98585396-1417-42c5-89e9-925e4cb34578.png)

### 5. ***Adding the list fields***
Adding the lists "evolutions" and "move" (skills) was very trick, because it involves relationships between tables and some specific annotations, but after some hardwork got things sorted.

![image](https://user-images.githubusercontent.com/72032836/133976455-ed99d032-9415-4fc7-9f9f-32a1983c8e75.png)

### 6. ***Accessing data from the database***
By far, the easiest way to access data from the database with Spring, is using the JPA Repository Interface:

![image](https://user-images.githubusercontent.com/72032836/133977149-8fb15225-096b-438a-b1cd-ab526feb72e6.png)

### 7. ***Architecture***
Aiming the most secure architecture, before sending the data to Controller class(end-points), data is encapsulated at a Service class, which handles the data given by the DAO and then give it to Contorller so information can be displayed.

### 8. ***Biggest Obstacle***
  After getting all things done like: mapping entities, making interface with JPARepository implemented, hand informations to service class process it and pass it on to Controller, and finally run it, there was no compile errors, but a Stack Overflow runtime exception was thrown. 
  After investigating, it came to me that the problem was with the "evolve-to" field, which is related to the evolutions of each pokemon. The problem was that every Pokemon displayed in the REST API I was doing have the field "evolves_to" that display all the evolutions that a pokemon has, but the evolutions are also pokemons with information, inclusive evolves_to ( in case this evolutions has another evolution). So when running the program the first pokemon is displayed and it access its evolution informations, that accessed its evolutions information an so on(because it also has the previous evolutions displayed so kept changing A to B, B to A).
  
  Best way of pulling it off? using DTOs, in other words, making a class with only the information I want to be displayed from pokemon and evolution, thi way the evolution of each pokemon only comes with simple info, like: id and name. And the loop no longer occured.
  
  ![image](https://user-images.githubusercontent.com/72032836/133979018-9256a9e4-73ff-4e64-8929-43d0bd2497f8.png)
  
  ### 9. ***Using Pagination***
  So with all errors solved, the last thing is paginate the API, but as soon as I started I realized that wouldn't be that easy, because to use the pagination given by the JPARepository it return a Page<Pokemon> object, so I couldn't just use the DTOs I had and therefore the loop problem would go back. So I used the ModelMapper library that maps an object to another type, and did this to every sing Pokemon using this command:

![image](https://user-images.githubusercontent.com/72032836/133979702-91e2198f-7ca7-4f17-b487-2acefbf8f31e.png)


   





## Endpoints
* /pokedex/{id} -> Returns PokeData, containing id, name, weight, height, stats, evolutions and types. 
* /pokedex/? -> Returns a pagination of Pokemon, 
