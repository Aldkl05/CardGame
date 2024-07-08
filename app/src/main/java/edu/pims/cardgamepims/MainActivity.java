package edu.pims.cardgamepims;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Decleration
    ImageView blackCadView, redCardView;

    Button resetBtn, playBtn;

    TextView msgTextView;

    int redCardNumber, blackCardNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // association java with xml

        blackCadView = findViewById(R.id.blackCard);
        redCardView = findViewById(R.id.redCard);
        resetBtn = findViewById(R.id.restBtn);
        playBtn = findViewById(R.id.playBtn);
        msgTextView = findViewById(R.id.resultMsg);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
                changeCard();
                checkWin();

            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });


    }


    int randomNumber(){
        Random randomNum = new Random();

        int num = randomNum.nextInt(13)+1;

        Log.d("random", num+"");

        return num;

    }


   void flipCard(){

        redCardNumber =  randomNumber();
        blackCardNumber = randomNumber();
    }

    void changeCard(){
        int resource = getResources().getIdentifier("black"+blackCardNumber, "drawable", getPackageName());

        blackCadView.setImageResource(resource);


        int resource2 = getResources().getIdentifier("red"+redCardNumber, "drawable", getPackageName());

        redCardView.setImageResource(resource2);
    }


    void checkWin(){
        String result = "";


        if(redCardNumber==blackCardNumber){
            result= "Draw!";
        }


        else if (blackCardNumber==1 && redCardNumber!=1){
            result = "Black Win!";
        }

        else if (redCardNumber==1 && blackCardNumber!=1){
            result = "Red Win!";
        }


        else if(blackCardNumber> redCardNumber){
            result = "Black Win!";
        }

        else if(redCardNumber>blackCardNumber){
            result = "Red Win!";
        }

        else if (redCardNumber==blackCardNumber) {
            result = "Draw!";

        }

        else {
            result = "";
        }
        msgTextView.setText(result);


    }

    void reset(){
        blackCardNumber= 0;
        redCardNumber=0;
        changeCard();
        msgTextView.setText("");


    }



}