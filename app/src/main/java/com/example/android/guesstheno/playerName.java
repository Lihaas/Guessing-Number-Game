package com.example.android.guesstheno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class playerName extends AppCompatActivity {
    String s = "Player 1";
    String ss = "Player 2";
    EditText playerNamo ;
    EditText playerName2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_player_name);
        playerNamo  = findViewById(R.id.player1name);
        playerName2 = findViewById(R.id.player2name);
        Button start = findViewById(R.id.startButton);


        //Send details of player to MainActivity.
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = playerNamo.getText().toString();
                if(s.isEmpty()){
                    s = "Player 1";
                }
                ss = playerName2.getText().toString();
                if(ss.isEmpty()){
                    ss = "Player 2";
                }

                Intent i = new Intent(playerName.this,MainActivity.class);
                i.putExtra("PlayerName",s);
                i.putExtra("PlayerName2",ss);
                startActivity(i);
        finish();


            }
        });





    }




}
