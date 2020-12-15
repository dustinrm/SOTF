package com.example.mainmenu;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
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
     * @param fileName
     * @return
     */
    public ArrayList<String> parseFile(String fileName) {
        ArrayList<String> words = new ArrayList<String>();
        AssetManager am = context.getAssets();
        String line;
        try{
            InputStream inputStream = am.open(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null){
                words.add(line);
            }
            bufferedReader.close();
        }catch (IOException ex){
            ex.printStackTrace();
            System.out.println("Class: TextGameFileInterface Method: parseFile");
        }
        System.out.println(words);
        return words;
    }
}
