package com.example.mobile_programming_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*버튼 동작하는 메소드*/
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_btn:
                Intent intent = new Intent(getApplicationContext(), Menu_Activity.class);
                startActivity(intent);
        }
    }
}