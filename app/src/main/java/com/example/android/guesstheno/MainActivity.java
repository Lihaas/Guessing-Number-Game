package com.example.android.guesstheno;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText guessOfPlayer1;
    EditText guessOfPlayer2;
    TextView hint1;
    TextView hint2;
    String a = "0";
    int counter = 0 ;
    int counter2 = 0;
    int privew = 0 ;
    int preview2 = 0;
    int otherNo = 0;
    int otherNo2 = 0;
    int i = 0;
    int ran1;
    int button = 0;
    int x;
    int x2;
    int turn = 3;
    String name;
    String name2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView  layer1Name = findViewById(R.id.player1text);
        TextView player2Name = findViewById(R.id.player2text);

        //Player guessing number
        guessOfPlayer1 = findViewById(R.id.player1);
        guessOfPlayer2 = findViewById(R.id.player2);

      //Hint id
       hint1 = findViewById(R.id.hint1);
       hint2 = findViewById(R.id.hint2);

       //Name of players
       name = getIntent().getExtras().getString("PlayerName");
       layer1Name.setText(name);
       name2 = getIntent().getExtras().getString("PlayerName2");
       player2Name.setText(name2);

       //Submit button
      Button submit1 = findViewById(R.id.submitButton);
      Button submit2 = findViewById(R.id.submitButton2);

      submit1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

           if(turn%2 != 0) {
               turn +=1;
               if (ran1 == 0) {
                   Random ran = new Random();
                   ran1 = ran.nextInt(100);

                   //This Toast for test purpose.
                /*   Toast.makeText(MainActivity.this, "" + ran1, Toast.LENGTH_SHORT).show();*/
               }

               a = a + guessOfPlayer1.getText().toString();

               if (button == 0) {
                   if (a.equals("0")) {
                       hint1.setText("Enter the no.");
                   } else {
                       button += 1;
                       int no = Integer.parseInt(a);

                       int x = Math.abs(no - ran1);
                       if (no != ran1) {
                           if (x <= 10) {
                               hint1.setText("Warm!!");
                           } else {
                               hint1.setText("COLD!!");
                           }
                       }

                       counter = counter + 1;
                       otherNo = no;
                       a = "0";

                   }


               } else {
                   if (otherNo != ran1) {
                       a = guessOfPlayer1.getText().toString();

                       if (a.equals("0")) {
                           hint1.setText("Enter the No");
                       } else {
                           privew = x;
                           int no = Integer.parseInt(a);
                           x = Math.abs(no - ran1);


                           if (x < privew) {
                               hint1.setText("NEAR");
                           } else {
                               hint1.setText("FAR");
                           }


                           counter = counter + 1;
                           otherNo = no;
                           a = "0";


                       }
                   }
                   if (otherNo == ran1) {
                       String s = "YOU WIN!!!! & Your Score = " + counter;
                       alertBox(name,counter);
                       hint1.setText(s);
                   }


               }


           } }

      });

      submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(turn%2 == 0) {
                    turn +=1;
                    if (ran1 == 0) {
                        Random ran = new Random();
                        ran1 = ran.nextInt(100);
                        //This Toast for test purpose.
                        /*   Toast.makeText(MainActivity.this, "" + ran1, Toast.LENGTH_SHORT).show();*/
                    }

                    a = a + guessOfPlayer2.getText().toString();

                    if (button == 0) {
                        if (a.equals("0")) {
                            hint2.setText("Enter the no.");
                        } else {
                            button += 1;
                            int no2 = Integer.parseInt(a);

                            int x = Math.abs(no2 - ran1);
                            if (no2 != ran1) {
                                if (x <= 10) {
                                    hint2.setText("Warm!!");
                                } else {
                                    hint2.setText("COLD!!");
                                }
                            }

                            counter2 = counter2 + 1;
                            otherNo2 = no2;
                            a = "0";

                        }

                    } else {
                        if (otherNo2 != ran1) {
                            a = guessOfPlayer2.getText().toString();

                            if (a.equals("0")) {
                                hint2.setText("Enter the No");
                            } else {
                                preview2 = x;
                                int no2 = Integer.parseInt(a);
                                x2 = Math.abs(no2 - ran1);


                                if (x2 < preview2) {
                                    hint2.setText("NEAR");
                                } else {
                                    hint2.setText("FAR");
                                }


                                counter2 = counter2 + 1;
                                otherNo2 = no2;
                                a = "0";


                            }
                        }
                        if (otherNo2 == ran1) {
                            String s = "YOU WIN!!!! & Your Score =" + counter2;
                            alertBox(name2,counter2);
                            hint2.setText(s);
                        }


                    }


                }

            }
        });
    }
    public  void alertBox(String winner , int count) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(winner + " is a winner with " + count);
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                "Play Again !!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(MainActivity.this, playerName.class);
                        startActivity(i);
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "Exit !!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(Intent.ACTION_MAIN);
                        i.addCategory( Intent.CATEGORY_HOME );
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        finish();
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder1.create();
        alert.show();
    }
}




