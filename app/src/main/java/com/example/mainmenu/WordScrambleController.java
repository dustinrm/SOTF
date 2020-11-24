package com.example.mainmenu;

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

import java.util.ArrayList;


public class WordScrambleController extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_scramble);
        WordScrambleGame game = new WordScrambleGame();
        TextGameFileInterface fileInterface = new TextGameFileInterface();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> letters = new ArrayList<String>();
        String fileName = "fruits";
        //temporary until file system is figured out
        words.add("apple");
        words.add("banana");
        words.add("orange");
        words.add("mango");
        words.add("melon");
        words.add("strawberry");
        words.add("pineapple");
        words.add("kiwi");
        words = game.chooseWords(4, words);
        letters = game.scrambleWords(words);
        TextView catText = (TextView) findViewById(R.id.category1TextView);
        catText.setText(fileName);
        GridView letterGrid = (GridView) findViewById(R.id.letterGrid);
        int matrixSize = game.matrixSize(letters);
        letterGrid.setNumColumns(matrixSize);
        letterGrid.setColumnWidth(200);
        letterGrid.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(WordScrambleController.this, android.R.layout.simple_list_item_1,letters);
        letterGrid.setAdapter(arrayAdapter);
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