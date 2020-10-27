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

    EditText name, loc, school;
    String fileName;

    long milNow;
    Date mDate;
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy_MM_dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_process);

        /*id 정의*/
        name = findViewById(R.id.info_name);
        loc = findViewById(R.id.info_loc);
        school = findViewById(R.id.info_school);

    }

    public void OnClick(View v) {
        FileOutputStream outputStream;
        if (v.getId() == R.id.save_info) {
            try {
                /*milNow = System.currentTimeMillis();
                mDate = new Date(milNow);*/

                fileName = name.toString() + ".txt";
                String str = Read_Info(fileName);
                outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                System.out.println(" 여기는 됨?");

                String getName = name.getText().toString();
                String getLoc = loc.getText().toString();
                String getSchool = school.getText().toString();
                String User_info = getName + "," + getLoc + "," + getSchool;
                outputStream.write(User_info.getBytes());
                outputStream.close();
                Toast.makeText(File_process.this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                Toast.makeText(File_process.this, "error", Toast.LENGTH_SHORT).show();
            }
        }
    }

    String Read_Info(String fileName) {
        FileInputStream fIn;
        try {
            fIn = openFileInput(fileName);
            byte[] txt = new byte[200];
            fIn.read(txt);
            fIn.close();

        } catch (IOException e) {
            System.out.println("error");

        }
        return "";
    }
}