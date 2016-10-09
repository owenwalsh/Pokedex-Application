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
 * The VersionGroupDetail puts move and version data into the pokemon object
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class VersionGroupDetail implements Serializable {

    @SerializedName("level_learned_at")
    @Expose
    private Integer levelLearnedAt;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;
    @SerializedName("move_learn_method")
    @Expose
    private MoveLearnMethod moveLearnMethod;

    /**
     * @return The levelLearnedAt
     */
    public Integer getLevelLearnedAt() {
        return levelLearnedAt;
    }

    /**
     * @param levelLearnedAt The level_learned_at
     */
    public void setLevelLearnedAt(Integer levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    /**
     * @return The versionGroup
     */
    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    /**
     * @param versionGroup The version_group
     */
    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

    /**
     * @return The moveLearnMethod
     */
    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    /**
     * @param moveLearnMethod The move_learn_method
     */
    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

}
