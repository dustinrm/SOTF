package com.example.mainmenu;

public interface GameInterface {
    //accepts recorded metrics and returns values
    public  int[] ParseMetrics(int[] metrics);
    //accepts recorded values and translates them into usable metrics
    public int[] TranslateMetrics(int[] values);
    
}
