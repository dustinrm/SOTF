package com.example.mainmenu;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WordScrambleGame implements GameInterface {
    //Attributes
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> fileNames = new ArrayList<String>();
    private ArrayList<String> letters = new ArrayList<String>();
    private  ArrayList<String> finalWords = new ArrayList<String>();
    private String fileName;
    Context context;
    Random random = new Random();
    TextGameFileInterface textGameFileInterface;
    //Constructor
    public WordScrambleGame(Context inputContext){
        getFileNames().add("Animals.txt");
        getFileNames().add("Fruits.txt");
        getFileNames().add("Instruments.txt");
        getFileNames().add("Sports.txt");
        this.fileName = getFileNames().get(random.nextInt(getFileNames().size()));
        this.textGameFileInterface = new TextGameFileInterface(inputContext);
        this.words = textGameFileInterface.parseFile(fileName);
        this.context = inputContext;
    }

    //Methods
    public void chooseWords(int wordNum){
        Collections.shuffle(this.getWords());
        this.finalWords =  new ArrayList<String>(words.subList(0,wordNum-1));
    }

    public void scrambleWords(){
        //make an array list where each word is broken down into its letters then scrambled
        for (String word:this.finalWords) {
            for(int i = 0; i < word.length(); i++){
                this.letters.add(word.substring(i, i + 1));
            }
        }
        Collections.shuffle(this.letters);
    }

    public boolean checkWord(String inputWord){
        return(finalWords.contains(inputWord));
    }

    public int matrixSize(ArrayList<String> letters){
        int arrayLength = letters.size();
        while(!(Math.sqrt(arrayLength) == (int) Math.sqrt(arrayLength))){
            arrayLength += 1;
        }
        return arrayLength;
    }

    public ArrayList<String> finalLetterArray(ArrayList<String> letters, int matrixSize){
        Random rand = new Random();
        for(int i = 0; i < ((matrixSize * matrixSize) - letters.size()); i++){
            letters.add(String.valueOf((char) rand.nextInt(26) + 'a'));
        }
        Collections.shuffle(letters);
        return letters;
    }

    @Override
    public int[] ParseMetrics(int[] metrics) {
        return new int[0];
    }

    @Override
    public int[] TranslateMetrics(int[] values) {
        return new int[0];
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public ArrayList<String> getFileNames() {
        return fileNames;
    }

    public ArrayList<String> getLetters() {
        return letters;
    }

    public String getFilename() {
        return fileName;
    }
}
