package au.com.owenwalsh.teamrocketssecretpokedex.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import au.com.owenwalsh.teamrocketssecretpokedex.R;

/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * Activity for loading the list of targeted pokemon
 * <p/>
 * The PokemonTargetListActivity holds a list of pokemon the user is yet to catch and has flagged as pokemon they
 * are currently searching for
 *
 * TODO: finish this class by passing the list and setting it to the recycler view with card layout and write an
 * onclick method to take the user to the description of the pokemon
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class PokemonTargetListActivity extends AppCompatActivity {
    /**
     * Method that sets the list of targeted pokemon to the view objects
     *
     * @param savedInstanceState a reference to a Bundle object that is passed into the onCreate method
     *                           of every Android Activity to return to its previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_target_list);
    }
}
