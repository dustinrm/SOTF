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
        WordScrambleGame game = new WordScrambleGame();
        Random random = new Random();
        //creating word Array
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> fileNames = new ArrayList<String>();
        fileNames.add("Animals.txt");
        fileNames.add("Fruits.txt");
        String fileName = fileNames.get(random.nextInt(fileNames.size()));
        AssetManager am = getApplicationContext().getAssets();
        String[] locales = am.getLocales();
        try {
            InputStream in = am.open(fileName);
            String line;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            while((line = bufferedReader.readLine()) != null){
                words.add(line);
            }
            System.out.println(words);
            bufferedReader.close();
        }catch (Exception e){
            System.out.println("Failed to open input stream.");
        }


        //creating letters
        ArrayList<String> letters = new ArrayList<String>();
        //chooses selected amount of words from total list of words
        words = game.chooseWords(4, words);
        System.out.println(words);
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

