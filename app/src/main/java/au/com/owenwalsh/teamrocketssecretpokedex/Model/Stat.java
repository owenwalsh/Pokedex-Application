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
 * The Stat class creates a list of stats for the relevant pokemon object
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class Stat implements Serializable {

    @SerializedName("base_stat")
    @Expose
    private Integer baseStat;
    @SerializedName("effort")
    @Expose
    private Integer effort;
    @SerializedName("stat")
    @Expose
    private StatList stat;

    public String toString(){
        return this.stat.getName();
    }





    /**
     *
     * @return
     * The baseStat
     */
    public Integer getBaseStat() {
        return baseStat;
    }

    /**
     *
     * @param baseStat
     * The base_stat
     */
    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

    /**
     *
     * @return
     * The effort
     */
    public Integer getEffort() {
        return effort;
    }

    /**
     *
     * @param effort
     * The effort
     */
    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    /**
     *
     * @return
     * The stat
     */
    public StatList getStat() {
        return stat;
    }

    /**
     *
     * @param stat
     * The stat
     */
    public void setStat(StatList stat) {
        this.stat = stat;
    }

}