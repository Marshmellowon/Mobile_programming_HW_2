package com.example.mobile_programming_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FilePermission;

public class MainActivity extends AppCompatActivity {
    Button menu, file;

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
            case R.id.file_stream:
                Intent intent_file = new Intent(getApplicationContext(), File_process.class);
                startActivity(intent_file);
        }
    }
}