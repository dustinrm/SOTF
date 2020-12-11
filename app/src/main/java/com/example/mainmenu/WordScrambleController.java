package com.example.mainmenu;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
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


public class WordScrambleController extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_scramble);
        WordScrambleGame game = new WordScrambleGame();

        //creating word Array
        ArrayList<String> words = new ArrayList<String>();
        String fileName = "Animals.txt";
        AssetManager am = getApplicationContext().getAssets();
        try {
            InputStream in = am.open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            while(bufferedReader.readLine() != null){
                words.add(bufferedReader.readLine());
            }
        }catch (Exception e){
            System.out.println("Failed to open input stream.");
        }


        //creating letters
        ArrayList<String> letters = new ArrayList<String>();
        //chooses selected amount of words from total list of words
        words = game.chooseWords(4, words);
        //scrambles letters from those selected words
        letters = game.scrambleWords(words);
        //display letters
        TextView catText = (TextView) findViewById(R.id.category1TextView);
        catText.setText(fileName);
        GridView letterGrid = (GridView) findViewById(R.id.letterGrid);
        int matrixSize = game.matrixSize(letters);
        letterGrid.setNumColumns((int) (Math.sqrt(matrixSize)));
        letterGrid.setColumnWidth(200);
        letterGrid.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(WordScrambleController.this, android.R.layout.simple_list_item_1,letters);
        letterGrid.setAdapter(arrayAdapter);

        //game functionality on button click
        Button chkBtn = (Button) findViewById(R.id.chkBtn);
        ArrayList<String> finalWords = words;
        chkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText typedWord = (EditText) findViewById(R.id.typedWord);
                TextView chkResponse = (TextView) findViewById(R.id.chkResponse);
                if(game.checkWord(typedWord.getText().toString(), finalWords)){
                    chkResponse.setText("You got it right!");
                }else{
                    chkResponse.setText("You got it wrong.");
                }
            }
        });
    }



}