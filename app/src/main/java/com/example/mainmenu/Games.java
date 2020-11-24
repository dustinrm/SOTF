package com.example.mainmenu;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class Games extends AppCompatActivity implements View.OnClickListener {
    private Button button, button2, button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_menu);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.button:
                i = new Intent(this, WordScrambleController.class);
                startActivity(i);
                break;
            //case R.id.button2 : i = new Intent(this, PictureMatchingController.class);startActivity(i); break;
            //case R.id.button3 : i = new Intent(this, TutorialController.class);startActivity(i); break;
            //case R.id.button4 : i = new Intent(this, ShapeSelectorController.class);startActivity(i); break;
            default:
                break;
        }
    }
}
