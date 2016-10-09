package au.com.owenwalsh.teamrocketssecretpokedex.View;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


import au.com.owenwalsh.teamrocketssecretpokedex.Model.PokemonDetailResponse;
import au.com.owenwalsh.teamrocketssecretpokedex.Model.PokemonList;
import au.com.owenwalsh.teamrocketssecretpokedex.PokeService.PokemonListAdapter;
import au.com.owenwalsh.teamrocketssecretpokedex.PokeService.PokemonServiceAPI;
import au.com.owenwalsh.teamrocketssecretpokedex.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * Activity for loading the list of pokemon
 * <p/>
 * The PokedexActivity shows a list of pokemon to the user accompanied by their
 * image and an instance of android text to speech that relays their name back to the user
 * when the speaker imageButton is pressed.
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class PokedexActivity extends AppCompatActivity implements PokedexInterface {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private PokemonListAdapter pokemonListAdapter;
    private ProgressDialog progress;
    private Retrofit retrofit;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson;
    private List<PokemonDetailResponse> pokemonDetailResponses;
    private static String POKEMON_LIST_KEY = "pokemonListKey";
    private PokemonList pokemonList;
    private ImageButton ttsImageButton;
    private TextToSpeech tts;
    public static final String POKEMON_OBJ = "POKEMON_NAME";
    private Context mContext;


    /**
     * Method that creates an instance of retrofit, initialises the view and loads pokedex data to the view
     *
     * @param savedInstanceState a reference to a Bundle object that is passed into the onCreate method
     *                           of every Android Activity to return to its previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        gson = new Gson();

        /**
         *  loading an instance of retrofit from the api base
         */
        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        /**
         * calling initViews method to linitialise the view data
         */
        initViews();

        /**
         * setting up an instance of android text to speech
         */
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });

        /**
         * finding the swipleRefreshLayout and setting it in order to refresh items
         */
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.contentView);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                refreshItems();
            }
        });


    }

    /**
     * This method refreshes the items in the pokedex list
     */
    void refreshItems() {
        loadPokedex();
        onItemsLoadComplete();
    }

    /**
     * this method toasts the user to let them know the list has been refreshed
     */
    void onItemsLoadComplete() {
        Toast.makeText(getApplicationContext(), "Refreshed", Toast.LENGTH_SHORT).show();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    /**
     * This method sets the view with a new recyclerview as the Layout then callls the loadPokedex
     * method to load the pokedex data into a card for each pokedex item
     */
    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.activity_pokemon_main_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadPokedex();


    }

    /**
     * This method sets a listener on the imageButton to speak the name of the pokemon corresponding to the
     * entry that is clicked
     *
     * @param pokemonName the name of the pokemon that is clicked
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onSpeakerClicked(String pokemonName) {
        System.out.println("************************Speaking pokemon Name*******************************");
        System.out.println(pokemonName);
        tts.speak(pokemonName, TextToSpeech.QUEUE_FLUSH, null, null);
        System.out.println("*******************************************************************************");
    }

    /**
     * This method creates a new service request and checks that a list of pokemon exists for the key
     * POKEMON_LIST_KEY. If this does not exist a loop is undertaken for the Kanto region pokemon and each
     * pokemon is added to a list. If the shared preferences reference exists we get the list of pokemon.
     */
    private void loadPokedex() {


        showProgressDialog();
        PokemonServiceAPI request = retrofit.create(PokemonServiceAPI.class);
        if (!PreferenceManager.getDefaultSharedPreferences(this).contains(POKEMON_LIST_KEY)) {
            pokemonDetailResponses = new ArrayList<>();
            for (int j = 1; j < 152; j++) {
                Call<PokemonDetailResponse> getPokemonDetail = request.getPokemonDetail(Integer.toString(j));
                getPokemonDetail.enqueue(new Callback<PokemonDetailResponse>() {
                    /**
                     * This method gets the response and adds the response to shared preferences
                     * @param call The service call to the retrofit instance
                     * @param response The response recieved back from the call
                     */
                    @Override
                    public void onResponse(Call<PokemonDetailResponse> call, Response<PokemonDetailResponse> response) {
                        System.out.println("********************************************************");
                        System.out.println("a new pokemon has been added to the list");
                        pokemonDetailResponses.add(response.body());
                        int size = pokemonDetailResponses.size();
                        System.out.println("number of pokemons=" + size);
                        System.out.println("********************************************************");
                        /**
                         * Once we have a list of the kanto pokemon add them to shared preferences and set the
                         * list adapter
                         */
                        if (size >= 151) {
                            saveToSharedPref();
                            setAdapter();
                        }
                    }

                    /**
                     * This method notifies the user that there was an error getting the pokemon
                     *
                     * @param call The call to the retrofit instance
                     * @param t the throwable that occurs if there is an error
                     */
                    @Override
                    public void onFailure(Call<PokemonDetailResponse> call, Throwable t) {
                        hideProgressDialog();
                        Toast.makeText(PokedexActivity.this, "oops! Something went wrong!", Toast.LENGTH_SHORT).show();
                        System.out.println(t);
                    }
                });
            }

        } else {
            /**
             * Access shared preferences for the particular key and retrieve the list
             */
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String pokemonResponse = sharedPreferences.getString(POKEMON_LIST_KEY, null);
            /**
             * if there is a response get the entire list back and display it
             */
            if (pokemonResponse != null) {
                //get entire list
                pokemonList = gson.fromJson(pokemonResponse, PokemonList.class);
                System.out.println(pokemonList.toString());
                setAdapter();

            }
        }
    }

    /**
     *  This method hides the dialog and sets the ListAdapter with the objects from the list and sets them to the
     *  recycler view
     */
    private void setAdapter() {
        hideProgressDialog();
        pokemonListAdapter = new PokemonListAdapter(this, pokemonList.getPokemonObjects(), this);
        recyclerView.setAdapter(pokemonListAdapter);
        pokemonListAdapter.notifyDataSetChanged();
    }

    /**
     * This method saves the list of response objects to memory
     */
    private void saveToSharedPref() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        pokemonList = new PokemonList(pokemonDetailResponses);
        editor.putString(POKEMON_LIST_KEY, gson.toJson(pokemonList));
        editor.commit();
        System.out.println("********************printing list************************");
        System.out.println(pokemonList.toString());
    }

    /**
     * This method is a reusable progress dialog to alert the users that we are waitinf for data
     */
    private void showProgressDialog() {
        if (progress == null) {
            progress = ProgressDialog.show(this, "Gotta Catch'em all!",
                    "Contacting Professor Oak for Pokemon Information..he could be a few minutes", true);
        }
    }
    /**
     * This method hides the progress dialog and resets it to null
     */
    private void hideProgressDialog() {
        if (progress != null && progress.isShowing()) {
            progress.hide();
            progress = null;
        }
    }

    /**
     * This method takes the user to the PokemonDescActivity to show the descriptions of the pokemon
     * that is clicked
     *
     * @param pokemonDetailResponses the response object for the particular pokemon
     */
    @Override
    public void onPokemonClicked(PokemonDetailResponse pokemonDetailResponses) {

        Intent intent = new Intent(this, PokemonDescActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("POKEMON_OBJ", pokemonDetailResponses);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}