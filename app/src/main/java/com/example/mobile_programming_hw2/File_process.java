package com.example.mobile_programming_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File_process extends AppCompatActivity {

    Button save, btn2;
    TextView name, loc, school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_process);

        save = findViewById(R.id.save);
        btn2 = findViewById(R.id.btn2);

        name = findViewById(R.id.name);
        loc = findViewById(R.id.loc);
        school = findViewById(R.id.school);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name_info = name.getText().toString();
                    String loc_info = loc.getText().toString();
                    String school_info = school.getText().toString();
                    String fileName = name_info + "'s_info.txt";
                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);

                    String str = name_info + "," + loc_info + "," + school_info;
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
                    String name_info = name.getText().toString();
                    String fileName = name_info + "'s_info.txt";

                    FileInputStream inputStream = openFileInput(fileName);
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