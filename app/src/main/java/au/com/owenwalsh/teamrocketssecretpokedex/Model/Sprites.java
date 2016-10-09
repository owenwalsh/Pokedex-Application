package au.com.owenwalsh.teamrocketssecretpokedex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * A model class to collect serialized data on the pokemon
 * <p/>
 * The Sprites takes in the images relevant to a pokemon objet
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class Sprites implements Serializable {

    @SerializedName("back_female")
    @Expose
    private String backFemale;
    @SerializedName("back_shiny_female")
    @Expose
    private String backShinyFemale;
    @SerializedName("back_default")
    @Expose
    private String backDefault;
    @SerializedName("front_female")
    @Expose
    private String frontFemale;
    @SerializedName("front_shiny_female")
    @Expose
    private String frontShinyFemale;
    @SerializedName("back_shiny")
    @Expose
    private String backShiny;
    @SerializedName("front_default")
    @Expose
    private String frontDefault;
    @SerializedName("front_shiny")
    @Expose
    private String frontShiny;

    /**
     *
     * @return
     * The backFemale
     */
    public String getBackFemale() {
        return backFemale;
    }

    /**
     *
     * @param backFemale
     * The back_female
     */
    public void setBackFemale(String backFemale) {
        this.backFemale = backFemale;
    }

    /**
     *
     * @return
     * The backShinyFemale
     */
    public String getBackShinyFemale() {
        return backShinyFemale;
    }

    /**
     *
     * @param backShinyFemale
     * The back_shiny_female
     */
    public void setBackShinyFemale(String backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }

    /**
     *
     * @return
     * The backDefault
     */
    public String getBackDefault() {
        return backDefault;
    }

    /**
     *
     * @param backDefault
     * The back_default
     */
    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    /**
     *
     * @return
     * The frontFemale
     */
    public String getFrontFemale() {
        return frontFemale;
    }

    /**
     *
     * @param frontFemale
     * The front_female
     */
    public void setFrontFemale(String frontFemale) {
        this.frontFemale = frontFemale;
    }

    /**
     *
     * @return
     * The frontShinyFemale
     */
    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }

    /**
     *
     * @param frontShinyFemale
     * The front_shiny_female
     */
    public void setFrontShinyFemale(String frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

    /**
     *
     * @return
     * The backShiny
     */
    public String getBackShiny() {
        return backShiny;
    }

    /**
     *
     * @param backShiny
     * The back_shiny
     */
    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    /**
     *
     * @return
     * The frontDefault
     */
    public String getFrontDefault() {
        return frontDefault;
    }

    /**
     *
     * @param frontDefault
     * The front_default
     */
    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    /**
     *
     * @return
     * The frontShiny
     */
    public String getFrontShiny() {
        return frontShiny;
    }

    /**
     *
     * @param frontShiny
     * The front_shiny
     */
    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

}