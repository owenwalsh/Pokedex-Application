package au.com.owenwalsh.teamrocketssecretpokedex.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import au.com.owenwalsh.teamrocketssecretpokedex.R;
/**
 * The TeamRocketSecretPokedex implements an application that is
 * presents a novel pokedex to the user. A main list of pokemon
 * is populated and a description of the pokemon is made available onClick
 * <p/>
 * Activity for loading a fade in splash screen when the application opens
 * <p/>
 * The SplashActivity passes an intent through to the PokedexActivity
 *
 * @author Owen Walsh
 * @version 1.0
 * @since 2016-10-04
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, PokedexActivity.class);
        startActivity(intent);
        finish();

    }
}