package com.example.mainmenu;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class WordScrambleController extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_scramble);
        WordScrambleGame game = new WordScrambleGame(this);
        //chooses selected amount of words from total list of words
        game.chooseWords(4);
        //scrambles letters from those selected words
        game.scrambleWords();
        //display letters
        TextView catText = (TextView) findViewById(R.id.category1TextView);
        catText.setText(game.getFilename());
        GridView letterGrid = (GridView) findViewById(R.id.letterGrid);
        letterGrid.setNumColumns((int) (Math.sqrt(game.matrixSize(game.getLetters()))));
        letterGrid.setColumnWidth(200);
        letterGrid.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(WordScrambleController.this, android.R.layout.simple_list_item_1,game.getLetters());
        letterGrid.setAdapter(arrayAdapter);

        //game functionality on button click
        Button chkBtn = (Button) findViewById(R.id.chkBtn);
        chkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText typedWord = (EditText) findViewById(R.id.typedWord);
                TextView chkResponse = (TextView) findViewById(R.id.chkResponse);
                if(game.checkWord(typedWord.getText().toString())){
                    chkResponse.setText("You got it right!");
                }else{
                    chkResponse.setText("You got it wrong.");
                }
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        chkResponse.setText("Go again!");
                    }
                },3000);
            }
        });
    }


}

