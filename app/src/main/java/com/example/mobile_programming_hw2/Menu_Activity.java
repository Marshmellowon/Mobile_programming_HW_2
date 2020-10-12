package com.example.mobile_programming_hw2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Menu_Activity extends AppCompatActivity {

    EditText name, phone, location_edit, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_);
        setTitle("정보 입력");
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        location_edit = findViewById(R.id.location_edit);
        registerForContextMenu(location_edit);
        email = findViewById(R.id.email);

    }

    /*option menu*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    /*버튼 동작*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                Toast.makeText(this, "menu1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu2:
                Toast.makeText(this, "menu2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu3:
                Toast.makeText(this, "menu3", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }/*option menu fin*/

    /*context menu*/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if (v == location_edit) {
            menu.setHeaderTitle("지역 선택");
            mInflater.inflate(R.menu.location, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.seoul:
                location_edit.setText("서울");
                return true;
            case R.id.gyung:
                location_edit.setText("경기");
                return true;
            case R.id.gang:
                location_edit.setText("강원");
                return true;
            case R.id.choong:
                location_edit.setText("충청");
                return true;
            case R.id.gyungsang:
                location_edit.setText("경상");
                return true;
            case R.id.jeon:
                location_edit.setText("전라");
                return true;
            case R.id.jeju:
                location_edit.setText("제주도");
                return true;
        }
        return super.onContextItemSelected(item);
    }
}

