package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mainmenu.Activities;
import com.example.mainmenu.Avatars;
import com.example.mainmenu.Games;
import com.example.mainmenu.R;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton gameButton, avatarButton, photoButton, activityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Define Buttons
        gameButton = (ImageButton) findViewById(R.id.gameButton);
        avatarButton = (ImageButton) findViewById(R.id.avatarButton);
        photoButton = (ImageButton) findViewById(R.id.photoButton);
        activityButton = (ImageButton) findViewById(R.id.activityButton);

        // Add click listener to buttons
        gameButton.setOnClickListener(this);
        avatarButton.setOnClickListener(this);
        photoButton.setOnClickListener(this);
        activityButton.setOnClickListener(this);


        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());

        TextView textViewDate = findViewById(R.id.text_view_date);
        textViewDate.setText(currentDate);

    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.gameButton : i = new Intent(this, Games.class);startActivity(i); break;
            case R.id.avatarButton : i = new Intent(this, Avatars.class);startActivity(i); break;
            case R.id.photoButton : i = new Intent(this, Photos.class);startActivity(i); break;
            case R.id.activityButton : i = new Intent(this, Activities.class);startActivity(i); break;
            default:break;
        }

    }


}