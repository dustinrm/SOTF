package com.example.mainmenu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WordScrambleGame implements GameInterface {
    //Constructor
    public WordScrambleGame(){

    }
    //Attributes

    //Methods
    public ArrayList<String> chooseWords(int wordNum, ArrayList<String> words){
        Collections.shuffle(words);
        ArrayList<String> selectedWords =  new ArrayList<String>(words.subList(0,wordNum-1));
        return selectedWords;
    }

    public ArrayList<String> scrambleWords(ArrayList<String> selectedWords){
        //make an array list where each word is broken down into its letters then scrambled
        ArrayList<String> letters = new ArrayList<String>();
        for (String word:selectedWords) {
            for(int i = 0; i < word.length(); i++){
                letters.add(word.substring(i, i + 1));
            }
        }
        Collections.shuffle(letters);
        return letters;
    }

    public boolean checkWord(String inputWord, ArrayList<String> words){
        return(words.contains(inputWord));
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
}
