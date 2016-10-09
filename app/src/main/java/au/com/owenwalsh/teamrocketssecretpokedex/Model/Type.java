package au.com.owenwalsh.teamrocketssecretpokedex.Model;

/**
 * Created by owenw on 7/10/2016.
 */
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
 * The Type creates a list of types for the pokemon object
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class Type implements Serializable {

    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("type")
    @Expose
    private TypeList type;

    public String toString(){
        return this.type.getName();
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
     * The type
     */
    public TypeList getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(TypeList type) {
        this.type = type;
    }

}
