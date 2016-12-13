package com.example.ergo.incremental.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.core_mechanics.Game;

/*
    Ceci est l'activité qui s'active lorsque la personne termine sa partie
    On demande au joueur si il veut rejouer
 */

public class GameOver extends AppCompatActivity {

    TextView ellapsedTimeText;
    TextView totalProgrammersText;
    TextView message;
    Button replayButton;
    Boolean manualRestart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Intent intent = getIntent();

        ellapsedTimeText = (TextView) findViewById(R.id.totalTime);
        totalProgrammersText = (TextView) findViewById(R.id.totalProgrammers);
        replayButton = (Button) findViewById(R.id.playAgain);
        message = (TextView) findViewById(R.id.message);


        //On affiche le temps que l'usager a dépensé sur cette partie ainsi que le nombre de programmeurs qu'il a acheté
        String ellapsedTime = intent.getStringExtra("ellapsedTime");
        String formatedTime = Game.formatTime(Integer.parseInt(ellapsedTime));
        String abandon = intent.getStringExtra("abandon");
        if(abandon != null) {
            if(abandon.equals("true")) {
                message.setText(getString(R.string.abandon));
                manualRestart = true;
            }
        }

        ellapsedTimeText.setText(formatedTime);
        totalProgrammersText.setText(intent.getStringExtra("totalProgrammers"));


    }

    public void playAgain(View view) {
        Intent myNewIntent = new Intent(MainActivity.getAppContext(), MainActivity.class);
        if(!manualRestart) {
            myNewIntent.putExtra("reset", "true");
            myNewIntent.putExtra("prestige", "true");
        } else {
            myNewIntent.putExtra("reset", "true");
            myNewIntent.putExtra("prestige", "false");
        }
        startActivity(myNewIntent);
        finish();
    }
}
