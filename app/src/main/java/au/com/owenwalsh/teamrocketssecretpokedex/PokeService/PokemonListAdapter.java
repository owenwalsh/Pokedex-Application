package au.com.owenwalsh.teamrocketssecretpokedex.PokeService;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import au.com.owenwalsh.teamrocketssecretpokedex.Model.PokemonDetailResponse;
import au.com.owenwalsh.teamrocketssecretpokedex.Model.PokemonList;
import au.com.owenwalsh.teamrocketssecretpokedex.R;
import au.com.owenwalsh.teamrocketssecretpokedex.View.PokedexInterface;

/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * Class that extends the recyclerview adapter that creates a list of responses
 * <p/>
 * The PokemonListAdapter creates and updates a list of PokemonDetailResponses and sets Pokedex data to the view
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {

    private PokedexInterface pokedexView;
    private List<PokemonDetailResponse> pokedex;
    private PokemonList pokemonlist;
    public Context mContext;

    /**
     * Constructor for the adapter
     *
     * @param pokedexView a contract of methods the adpater must implement
     * @param pokemonDetails the list of response objects
     * @param mContext the context
     */
    public PokemonListAdapter(PokedexInterface pokedexView, List<PokemonDetailResponse> pokemonDetails, Context mContext) {
        this.pokedexView = pokedexView;
        this.pokedex = pokemonDetails;
        this.mContext = mContext;
    }

    /**
     *  This method inflates the view data into the card row
     * @param viewGroup the viewgroup
     * @param i the int for the card
     * @return a new viewholder with the inflated view
     */
    @Override
    public PokemonListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pokemon_row, viewGroup, false);
        return new ViewHolder(view);
    }

    /**
     *  This method sets the relevant pokdex details to the card
     * @param viewHolder the viewholder created above
     * @param i the integer to set data to for each pokemon to the card
     */
    @Override
    public void onBindViewHolder(final PokemonListAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.pokemonName.setText(pokedex.get(i).name);
        Picasso.with(mContext).load(pokedex.get(i).sprites.getFrontDefault())
                .resize(100,100)
                .into(viewHolder.rowPokeImage);
        viewHolder.pokemonLayout.setOnClickListener(new View.OnClickListener() {
            /**
             *  A method that gets the integer of the pokemon clicked
             * @param view the view
             */
            @Override
            public void onClick(View view) {
                pokedexView.onPokemonClicked(pokedex.get(i));
                System.out.println("pokemon clicked");

            }
        });

        /**
         * This method adds a listener to the speakker ImageButton and gets the name of the pokemon clicked
         */
        viewHolder.speakerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pokedexView.onSpeakerClicked(viewHolder.pokemonName.getText().toString());
            }
        });
    }

    /**
     * This method updates the list adapter with changes to the list
     * @param pokedex the response objects
     */
    public void updateListAdapter(List<PokemonDetailResponse> pokedex) {
        this.pokedex = pokedex;
    }

    /**
     * This method returns the size of the list of responses so we can determine when to stop taking more pokemon
     *
     * @return the size of the pokedezx
     */
    @Override
    public int getItemCount() {
        return pokedex.size();
    }

    /**
     * A class that extends teh recycler view to get all view components
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView pokemonName;
        public ImageView rowPokeImage;
        public RelativeLayout pokemonLayout;
        public ImageButton speakerIcon;

        public ViewHolder(View view) {
            super(view);
            pokemonLayout = (RelativeLayout) view.findViewById(R.id.pokemon_card);
            pokemonName = (TextView) view.findViewById(R.id.pokemon_name);
            rowPokeImage = (ImageView) view.findViewById(R.id.row_poke_image);
            speakerIcon = (ImageButton) view.findViewById(R.id.speaker_icon);
        }
    }
}
