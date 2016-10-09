package au.com.owenwalsh.teamrocketssecretpokedex.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import au.com.owenwalsh.teamrocketssecretpokedex.R;

/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * Activity for loading the list of caught pokemon
 * <p/>
 * The PokemonCaughtListActivity holds a list of pokemon the user as stipulated as pokemon
 * they have caught.
 *
 * TODO: finish this class by passing the list and setting it to the recycler view with card layout and write an
 * onclick method to take the user to the description of the caught pokemon
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class PokemonCaughtListActivity extends AppCompatActivity {
    /**
     * Method that sets the list of caught pokemon to the view objects
     *
     * @param savedInstanceState a reference to a Bundle object that is passed into the onCreate method
     *                           of every Android Activity to return to its previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_caught_list);
    }
}
