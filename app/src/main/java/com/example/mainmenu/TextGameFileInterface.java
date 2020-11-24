package com.example.mainmenu;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TextGameFileInterface {

    //Constructor
    public TextGameFileInterface(){

    }

    //Attributes

    //Methods

    /**
     *
     * @param difficulty
     * @return
     * @throws FileNotFoundException
     * Accepts an Input File where there is one word on each line and
     * returns an ArrayList of those words
     */
    public ArrayList<String> parseFileRand(int difficulty){
        ArrayList<String> words = new ArrayList<String>();
        File[] paths;
        Random rand = new Random();
        try{
            File dir = new File(Environment.getExternalStorageDirectory() + File.separator + "TestGames" + File.separator + "Game1");
            paths = dir.listFiles();
            if(paths == null){
                System.out.println("IM NULL");
            }else {
                File randomFile = paths[rand.nextInt(paths.length)];
                Scanner fileScanner = new Scanner(randomFile);
                while (fileScanner.hasNextLine()) {
                    words.add(fileScanner.nextLine());
                }
                for (File path : paths) {
                    System.out.println(path);
                }
            }

        }catch (FileNotFoundException e){
            System.out.println(e);
        }
        return words;
    }

    public ArrayList<String> parseFile(String fileName){
        ArrayList<String> words = new ArrayList<String>();
        try{
            File textFile = new File(fileName);
            if(textFile.exists()){
                Scanner sc = new Scanner(textFile);
                while (sc.hasNextLine()){
                    System.out.println(sc.nextLine());
                    words.add(sc.nextLine());
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return words;
    }
}
