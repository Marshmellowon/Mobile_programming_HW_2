package com.example.mobile_programming_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File_process extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_process);

        btn1 = findViewById(R.id.write_file);
        btn2 = findViewById(R.id.read_file);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outputStream = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = "안드로이드";
                    outputStream.write(str.getBytes());
                    outputStream.close();
                    Toast.makeText(File_process.this, "파일 생성됨", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inputStream = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inputStream.read(txt);
                    String str = new String(txt);
                    Toast.makeText(File_process.this, str, Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    System.out.println("error input");
                }
            }
        });
    }
}