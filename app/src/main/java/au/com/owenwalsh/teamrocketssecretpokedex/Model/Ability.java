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
 * The Ability model class sets the list of abilities of the pokemon object
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class Ability implements Serializable {

    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("ability")
    @Expose
    private AbilityList ability;

    public String toString(){
        return this.ability.getName();
    }


    /**
     *
     * @return
     * The isHidden
     */
    public Boolean getIsHidden() {
        return isHidden;
    }

    /**
     *
     * @param isHidden
     * The is_hidden
     */
    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     *
     * @return
     * The slot
     */
    public Integer getSlot() {
        return slot;
    }

    /**
     *
     * @param slot
     * The slot
     */
    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    /**
     *
     * @return
     * The ability
     */
    public AbilityList getAbility() {
        return ability;
    }

    /**
     *
     * @param ability
     * The ability
     */
    public void setAbility(AbilityList ability) {
        this.ability = ability;
    }



}
