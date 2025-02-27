package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activePlayer = 0; // 0 --> red , 1 --> yellow
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean isGameActive = true;

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        gameState[tappedCounter] = activePlayer;
        if (isGameActive) {

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.redcircle);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.yellowcircle);
                activePlayer = 0;
            }

            counter.setTranslationY(-1500);
            counter.animate().translationYBy(1500).setDuration(300);
            for (int[] winningPositions : winningPositions) {
                if (gameState[winningPositions[0]] == gameState[winningPositions[1]] && gameState[winningPositions[1]] == gameState[winningPositions[2]] && gameState[winningPositions[0]] != 2) {
                    // someone has won the game
                    Toast.makeText(this, "Won the game", Toast.LENGTH_SHORT).show();
                    isGameActive = false;
                    if (activePlayer == 0) {
                        Toast.makeText(this, "Red has won", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}