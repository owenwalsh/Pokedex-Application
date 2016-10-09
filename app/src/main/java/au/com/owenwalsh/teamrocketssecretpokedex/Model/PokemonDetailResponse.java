package au.com.owenwalsh.teamrocketssecretpokedex.Model;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * A model class to collect serialized data on the pokemon
 * <p/>
 * The PokemonDetailResponse model class sets the information for a pokemon object from the other model classes
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class PokemonDetailResponse implements Serializable{

    @SerializedName("id")
    public final int id;

    @SerializedName("name")
    public final String name;

    @SerializedName("base_experience")
    public final int baseExperience;

    @SerializedName("height")
    public final int height;

    @SerializedName("is_default")
    public final boolean isDefault;

    @SerializedName("order")
    public final int order;

    @SerializedName("weight")
    public final int weight;

    @SerializedName("abilities")
    public List<Ability> abilities = new ArrayList<Ability>();

    @SerializedName("forms")
    public List<Form> forms = new ArrayList<Form>();

    @SerializedName("species")
    public Species species;

    @SerializedName("sprites")
    public Sprites sprites;

    @SerializedName("stats")
    public List<Stat> stats = new ArrayList<Stat>();

    @SerializedName("types")
    public List<Type> types = new ArrayList<Type>();

    @SerializedName("moves")
    public List<Move> moves = new ArrayList<Move>();

    /**
     * Default constructor for the pokemon object
     *
     * @param types the pokemons type
     * @param id the id of the pokemon
     * @param name the name of the pokemon
     * @param baseExperience the base experience of the pokemon
     * @param height the height of the pokemon
     * @param isDefault unused
     * @param order unused
     * @param weight the weight of the pokemon
     * @param abilities the pokemons abilities
     * @param forms the pokemons forms
     * @param species the species of the pokemon
     * @param sprites the images of the pokemon
     * @param stats the pokemons stats
     * @param moves the pokemons moves
     */
    public PokemonDetailResponse(List<Type> types, int id, String name, int baseExperience, int height, boolean isDefault, int order, int weight, List<Ability> abilities, List<Form> forms, Species species, Sprites sprites, List<Stat> stats, List<Move> moves) {
        this.types = types;
        this.id = id;
        this.name = name;
        this.baseExperience = baseExperience;
        this.height = height;
        this.isDefault = isDefault;
        this.order = order;
        this.weight = weight;
        this.abilities = abilities;
        this.forms = forms;
        this.species = species;
        this.sprites = sprites;
        this.stats = stats;
        this.moves = moves;
    }





}