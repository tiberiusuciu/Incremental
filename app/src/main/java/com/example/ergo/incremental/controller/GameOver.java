package com.example.ergo.incremental.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ergo.incremental.R;
import com.example.ergo.incremental.model.core_mechanics.Game;
import com.example.ergo.incremental.model.threads.EllapsedTimeThread;
import com.example.ergo.incremental.model.utils.UserStats;

public class GameOver extends AppCompatActivity {

    TextView ellapsedTimeText;
    TextView totalFarmersText;
    Button replayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Intent intent = getIntent();

        ellapsedTimeText = (TextView) findViewById(R.id.totalTime);
        totalFarmersText = (TextView) findViewById(R.id.totalFarmers);
        replayButton = (Button) findViewById(R.id.playAgain);

        String ellapsedTime = intent.getStringExtra("ellapsedTime");
        String formatedTime = Game.formatTime(Integer.parseInt(ellapsedTime));

        ellapsedTimeText.setText(formatedTime);
        totalFarmersText.setText(intent.getStringExtra("totalFarmers"));


    }

    public void playAgain(View view) {
        Intent myNewIntent = new Intent(MainActivity.getAppContext(), MainActivity.class);

        myNewIntent.putExtra("reset", "true");
        EllapsedTimeThread.setEllapsedTime(0);
        Game.isGameOver = false;
        Game.currentLevel = 0;
        Game.levelUp();
        MainActivity.user.setCodesPerTap(UserStats.STARTING_CODES_PER_TAP);
        MainActivity.user.resetTeam();
        MainActivity.user.resetWallet();
        MainActivity.user.setCodesPerSecond(UserStats.STARTING_CODES_PER_SECOND);

        startActivity(myNewIntent);
    }
}
