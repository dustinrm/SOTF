package com.example.mainmenu;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TextGameFileInterface extends AppCompatActivity {
    //Attributes
    Context context;
    //Constructor
    public TextGameFileInterface(Context inputContext) {

        context = inputContext;
    }


    //Methods

    /**
     * @param textFile
     * @return
     */
    public ArrayList<String> parseFile(InputStream textFile) {
        ArrayList<String> words = new ArrayList<String>();
        char[] wordArray = new char[100];
        int index = 0;
        try {
            AssetManager am = this.getAssets();
            try {
                //InputStream textFile = am.open(fileName);
                //read until end of file
                while (textFile.read() != -1) {
                    //read a byte from the stream until new line
                    while (textFile.read() != 10) {
                        wordArray[index] = (char) textFile.read();
                        index++;
                    }
                    //add the word to the word array
                    words.add(wordArray.toString());
                    //clear word
                    wordArray = null;
                }
                textFile.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("HERE!");
        }

        return words;
    }
}
