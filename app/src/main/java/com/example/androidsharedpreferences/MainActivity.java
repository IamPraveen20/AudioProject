package com.example.androidsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button red,green,yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        red = findViewById(R.id.redbutton);
        green = findViewById(R.id.greenbutton);
        yellow = findViewById(R.id.yellowbutton);

        if(getcolor()!=getResources().getColor(R.color.colorPrimary)){
            toolbar.setBackgroundColor(getcolor());
            getWindow().setStatusBarColor(getcolor());
        }
    }

    public void buttonred(View view) {
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
    }

    public void buttongreen(View view) {
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorGreen));
    }

    public void buttonyellow(View view) {
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorYellow));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorYellow));
    }

    public void storecolor(int color){
        SharedPreferences preferences = getSharedPreferences("Toolbar",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("color",color);
        editor.apply();
    }

    private int getcolor(){
        SharedPreferences preferences = getSharedPreferences("Toolbar",MODE_PRIVATE);
        int selectedcolor = preferences.getInt("color",getResources().getColor(R.color.colorPrimary));
        return selectedcolor;
    }

}
