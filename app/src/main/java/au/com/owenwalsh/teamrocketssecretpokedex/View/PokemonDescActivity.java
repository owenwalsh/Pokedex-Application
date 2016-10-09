package au.com.owenwalsh.teamrocketssecretpokedex.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import au.com.owenwalsh.teamrocketssecretpokedex.Model.Form;
import au.com.owenwalsh.teamrocketssecretpokedex.R;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import au.com.owenwalsh.teamrocketssecretpokedex.Model.Ability;
import au.com.owenwalsh.teamrocketssecretpokedex.Model.Move;
import au.com.owenwalsh.teamrocketssecretpokedex.Model.PokemonDetailResponse;
import au.com.owenwalsh.teamrocketssecretpokedex.Model.Stat;
import au.com.owenwalsh.teamrocketssecretpokedex.Model.Type;
import au.com.owenwalsh.teamrocketssecretpokedex.R;

/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * Activity for loading the descriptions of a pokemon
 * <p/>
 * The PokemonDescActivity shows a range of descriptions about a particular pokemon
 * including there type, abilities, stats and moves.
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class PokemonDescActivity extends AppCompatActivity {

    private static final String POKEMON_OBJ = "POKEMON_NAME";
    private TextView pokemonNameTextView;
    private ImageView pokemonImageView;
    private ImageView pokemonBackImageView;
    private TextView pokemonSpeciesTextView;
    private ListView pokemonTypeListView;
    private ImageButton ttsImageButton;
    private ImageButton caughtImageButton;
    private ImageButton searchingImageButton;
    private TextToSpeech tts;
    private TextView heightTextView;
    private TextView pokeBaseExperienceTextView;
    private TextView weightTextView;
    private ListView pokemonAbilitiesListView;
    private ListView pokemonMovesListView;
    private ListView pokemonStatsListView;
    private ListView pokemonStatNamesListView;
    private ListView pokemonStatEffortListView;

    /**
     * Method that sets description data to the view
     *
     * @param savedInstanceState a reference to a Bundle object that is passed into the onCreate method
     *                           of every Android Activity to return to its previous state
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_desc);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        final PokemonDetailResponse pokemonDetailResponses = (PokemonDetailResponse) bundle.getSerializable("POKEMON_OBJ");

        /*
         * set text to speech up
         */
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });


        /*
         * find all view components
         */
        pokemonNameTextView = (TextView) findViewById(R.id.pokemon_name);
        pokemonImageView = (ImageView) findViewById(R.id.pokemon_main_image);
        pokemonBackImageView = (ImageView) findViewById(R.id.pokemon_main_back_image);
        pokemonTypeListView = (ListView) findViewById(R.id.pokemon_type);
        pokemonAbilitiesListView = (ListView) findViewById(R.id.pokemon_abilities);
        ttsImageButton = (ImageButton) findViewById(R.id.speaker_icon);
        heightTextView = (TextView) findViewById(R.id.pokemon_height);
        caughtImageButton = (ImageButton) findViewById(R.id.caught_icon);
        searchingImageButton = (ImageButton) findViewById(R.id.binocular_icon);
        pokeBaseExperienceTextView = (TextView) findViewById(R.id.pokemon_base_experience);
        weightTextView = (TextView) findViewById(R.id.pokemon_weight);
        pokemonMovesListView = (ListView) findViewById(R.id.pokemon_moves);
        pokemonStatsListView = (ListView) findViewById(R.id.pokemon_stats);
        pokemonStatNamesListView = (ListView) findViewById(R.id.pokemon_stat_names);
        pokemonStatEffortListView = (ListView) findViewById(R.id.pokemon_stats_effort);


        /*
         * set all gui components to relevant parameters
         *
         * utilises picasso to set and manipulate images
         */
        Picasso.with(this)
                .load(pokemonDetailResponses.sprites.getFrontDefault())
                .resize(500, 500)
                .into(pokemonImageView);
        Picasso.with(this)
                .load(pokemonDetailResponses.sprites.getBackDefault())
                .resize(500, 500)
                .into(pokemonBackImageView);

        pokemonNameTextView.setText(pokemonDetailResponses.name);
        Float height = Float.valueOf(pokemonDetailResponses.height);
        Float heightDiv = (height / 10);
        String heightSet = heightDiv.toString();
        heightTextView.setText(heightSet);
        Float weight = Float.valueOf(pokemonDetailResponses.weight);
        Float weightDiv = (weight / 10);
        weightTextView.setText(weightDiv.toString());
        final String baseExperience = ((Integer) pokemonDetailResponses.baseExperience).toString();
        pokeBaseExperienceTextView.setText(baseExperience);


        /*
         *  Creates a new list of moves by looping through the response
         *  sets the ArrayList to the ListView and inflates it at a particular height
         */
        List<String> movesArr = new ArrayList<String>();
        for (Move move : pokemonDetailResponses.moves) {
            movesArr.add(move.toString());
        }
        pokemonMovesListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movesArr));
        RelativeLayout.LayoutParams lp5 = (RelativeLayout.LayoutParams) pokemonMovesListView.getLayoutParams();
        lp5.height = 1000;
        pokemonMovesListView.setLayoutParams(lp5);

        /*
         *  Creates a new list of stat names by looping through the response
         *  sets the ArrayList to the ListView and inflates it at a particular height
         */
        List<String> statsListArr = new ArrayList<String>();
        for (Stat stat : pokemonDetailResponses.stats) {
            statsListArr.add(stat.getStat().getName().toString());
        }
        pokemonStatNamesListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, statsListArr));
        LinearLayout.LayoutParams lp2 = (LinearLayout.LayoutParams) pokemonStatNamesListView.getLayoutParams();
        lp2.height = 1000;
        pokemonStatNamesListView.setLayoutParams(lp2);

        /*
         *  Creates a new list of stat base points by looping through the response
         *  sets the ArrayList to the ListView and inflates it at a particular height
         */
        List<String> statsArr = new ArrayList<String>();
        for (Stat stat : pokemonDetailResponses.stats) {
            statsArr.add(stat.getBaseStat().toString());
        }
        pokemonStatsListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, statsArr));
        LinearLayout.LayoutParams lp3 = (LinearLayout.LayoutParams) pokemonStatsListView.getLayoutParams();
        lp3.height = 1000;
        pokemonStatsListView.setLayoutParams(lp3);

        /*
         *  Creates a new list of stat effort points by looping through the response
         *  sets the ArrayList to the ListView and inflates it at a particular height
         */
        List<String> statEffortArr = new ArrayList<String>();
        for (Stat stat : pokemonDetailResponses.stats) {
            statEffortArr.add(stat.getEffort().toString());
        }

        pokemonStatEffortListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, statEffortArr));
        LinearLayout.LayoutParams lp4 = (LinearLayout.LayoutParams) pokemonStatEffortListView.getLayoutParams();
        lp4.height = 1000;
        pokemonStatEffortListView.setLayoutParams(lp4);


        /*
         *  Creates a new list of the pokemons abilities by looping through the response
         *  sets the ArrayList to the ListView and inflates it at a particular height
         */
        List<String> abilitiesArr = new ArrayList<String>();
        for (Ability ability : pokemonDetailResponses.abilities) {
            abilitiesArr.add(ability.toString());
        }
        pokemonAbilitiesListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, abilitiesArr));
        RelativeLayout.LayoutParams lp1 = (RelativeLayout.LayoutParams) pokemonAbilitiesListView.getLayoutParams();
        lp1.height = 300;
        pokemonAbilitiesListView.setLayoutParams(lp1);


        /*
         *  Creates a new list of the pokemons type by looping through the response
         *  sets the ArrayList to the ListView and inflates it at a particular height
         */
        final List<String> typeArr = new ArrayList<String>();
        for (Type type : pokemonDetailResponses.types) {
            typeArr.add(type.toString());
        }
        pokemonTypeListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, typeArr));
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) pokemonTypeListView.getLayoutParams();
        lp.height = 300;
        pokemonTypeListView.setLayoutParams(lp);

        final List<String> formArr = new ArrayList<>();
        for(Form form : pokemonDetailResponses.forms){
            formArr.add(form.toString());
        }
        /**
         * This method sets a new listener for the speaker button that takes in
         * numerous values from the pokemons description and uses Android Text to
         * speech to relay this information back to the user.
         */
        ttsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View view) {
                String pokemonName = (String) pokemonNameTextView.getText();
                String height = (String) heightTextView.getText();
                String weight = (String) weightTextView.getText();
                System.out.println(pokemonName);
                tts.speak(pokemonName + "is approximately "
                                + height + "meters tall"
                                + pokemonName + "weighs approximately "
                                + weight + "kilos."
                                + "A Trainer will earn "
                                + baseExperience + "base experience points for dee feeting"
                                + pokemonName
                                + pokemonName
                                + "is a"
                                + typeArr.toString() + "po kay mon"
                        , TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        /**
         * This method sets a new listener for the pokeball icon, sets the pokemon to an arrayList
         * of caught pokemon and moves the user to the PokemonCaughtListActivity allowing them to keep
         * track of pokemon they have caught
         *
         * TODO : check if pokemon exists in arrayList, toast user if not. Add pokemon to list. Build intent to move user to the new activity
         */
        caughtImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PokemonDescActivity.this, "Congratulations on catching " + pokemonDetailResponses.name + "! Pokemon added to your caught list", Toast.LENGTH_SHORT).show();
                //check if shared preferences exits, if not, create it, create an array, pass this in, pass the array in
                //else add to shared preferences
                //create intent to move to PokemonCaughtListActivity

            }
        });

        /**
         * This method sets a new listener for the binoculars icon, sets the pokemon to an arrayList
         * of targeted pokemon and moves the user to the PokemonCaughtListActivity allowing them to keep
         * track of pokemon they are currently searching for
         *
         * TODO : check if pokemon exists in arrayList, toast user if not. Add pokemon to list. Build intent to move user to the new activity
         */
        searchingImageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(PokemonDescActivity.this, "Good luck finding " + pokemonDetailResponses.name + "!, we have added it to your search list", Toast.LENGTH_SHORT).show();
                //check if shared preferences exits, if not, create it, create an array, pass this in, pass the array in
                //else add to shared preferences
                //create intent to move to PokemonTargetListActivity
            }
        });
        
    }
}
