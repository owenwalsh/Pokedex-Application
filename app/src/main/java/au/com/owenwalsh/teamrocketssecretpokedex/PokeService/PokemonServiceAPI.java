package au.com.owenwalsh.teamrocketssecretpokedex.PokeService;

import au.com.owenwalsh.teamrocketssecretpokedex.Model.PokemonDetailResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * Service for calling the api endpoint with the relevant pokemon id
 * <p/>
 * The PokemonServiceAPI makes a call to the specified endpoint and gets the response for the particular id it is passed
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public interface PokemonServiceAPI {
    @GET("pokemon/{id}")
    Call<PokemonDetailResponse> getPokemonDetail(@Path("id") String id);

}
