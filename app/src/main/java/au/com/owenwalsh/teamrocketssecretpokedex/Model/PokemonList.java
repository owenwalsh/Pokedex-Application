package au.com.owenwalsh.teamrocketssecretpokedex.Model;

/**
 * Created by owenw on 7/10/2016.
 */
import java.io.Serializable;
import java.util.List;

/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * A class to create a pokemon list
 * <p/>
 * The PokemonList class creates a list of pokemon objects
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class PokemonList implements Serializable {
    List <PokemonDetailResponse> pokemonObjects;

    /**
     * Default Constructor for the PokemonList
     *
     * @param pokemonObjects the pokemon objects
     */
    public PokemonList(List<PokemonDetailResponse> pokemonObjects) {
        this.pokemonObjects = pokemonObjects;
    }

    /**
     * Method to get the list of pokemon objects
     *
     * @return the pokemon objects
     */
    public List<PokemonDetailResponse> getPokemonObjects() {
        return pokemonObjects;
    }
}
