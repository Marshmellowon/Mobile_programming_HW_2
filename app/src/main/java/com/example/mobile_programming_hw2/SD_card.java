package com.example.mobile_programming_hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class SD_card extends Activity {
    Button prev, next;
    myPictureView myPictureView;
    int curNum;
    File[] imgFile;
    String imgFname;
    TextView imgnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_d_card);
        setTitle("사진 뷰어");
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        myPictureView = findViewById(R.id.myPictureView);

        imgFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();

        assert imgFile != null;
        imgFname = imgFile[0].toString();
        myPictureView.imagePath = imgFname;

        prev.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (curNum <= 0) {
                    Toast.makeText(SD_card.this, "첫번째 그림", Toast.LENGTH_SHORT).show();
                } else {
                    curNum--;
                    imgFname = imgFile[curNum].toString();
                    myPictureView.imagePath = imgFname;
                    myPictureView.invalidate();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (curNum >= imgFile.length - 1) {
                    Toast.makeText(SD_card.this, "마지막 그림", Toast.LENGTH_SHORT).show();
                } else {
                    curNum++;
                    imgFname = imgFile[curNum].toString();
                    myPictureView.imagePath = imgFname;
                    myPictureView.invalidate();
                }
            }
        });
    }
}