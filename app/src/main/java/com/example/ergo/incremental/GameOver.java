package com.example.ergo.incremental;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ergo.incremental.core_mechanics.Game;
import com.example.ergo.incremental.threads.EllapsedTimeThread;

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

    protected void playAgain(View view) {
        Intent myNewIntent = new Intent(MainActivity.getAppContext(), MainActivity.class);
        startActivity(myNewIntent);
    }
}
