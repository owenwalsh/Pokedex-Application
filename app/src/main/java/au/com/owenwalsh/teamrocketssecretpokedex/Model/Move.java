package au.com.owenwalsh.teamrocketssecretpokedex.Model;

/**
 * Created by owenw on 7/10/2016.
 */
import java.io.Serializable;
import java.util.List;


import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Move implements Serializable {

    @SerializedName("move")
    @Expose
    private MoveList move;
    @SerializedName("version_group_details")
    @Expose
    private List<VersionGroupDetail> versionGroupDetails = new ArrayList<VersionGroupDetail>();

    public String toString(){
        return this.move.getName();
    }

    /**
     *
     * @return
     * The move
     */
    public MoveList getMove() {
        return move;
    }

    /**
     *
     * @param move
     * The move
     */
    public void setMove(MoveList move) {
        this.move = move;
    }

    /**
     *
     * @return
     * The versionGroupDetails
     */
    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    /**
     *
     * @param versionGroupDetails
     * The version_group_details
     */
    public void setVersionGroupDetails(List<VersionGroupDetail> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }

}
