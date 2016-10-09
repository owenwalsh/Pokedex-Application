package au.com.owenwalsh.teamrocketssecretpokedex.View;

import java.util.List;


import au.com.owenwalsh.teamrocketssecretpokedex.Model.PokemonDetailResponse;

/**
 * Created by owenw on 7/10/2016.
 */
public interface PokedexInterface {

    void onPokemonClicked(PokemonDetailResponse pokemonDetailResponses);

    void onSpeakerClicked(String pokemonName);

}
