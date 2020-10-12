package com.example.mobile_programming_hw2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Menu_Activity extends AppCompatActivity {

    EditText name, phone, location_edit, email;
    LinearLayout layout;
    TextView title, txtname, txtphone, txtloc, txtemail;
    Button fin;

    View findlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_);
        setTitle("정보 입력");
        layout = findViewById(R.id.layout_);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        location_edit = findViewById(R.id.location_edit);
        registerForContextMenu(location_edit);
        email = findViewById(R.id.email);

        /*textview*/
        title = findViewById(R.id.title_);
        txtname = findViewById(R.id.txtname);
        txtphone = findViewById(R.id.txtphone);
        txtloc = findViewById(R.id.txtloc);
        txtemail = findViewById(R.id.txtemail);

        /*Button*/
        fin = findViewById(R.id.fin_btn);

    }

    /*button click*/
    public void onClick(View v) {
        if (v.getId() == R.id.fin_btn) {
            findlog = View.inflate(Menu_Activity.this, R.layout.fin, null);
            AlertDialog.Builder dlog = new AlertDialog.Builder(Menu_Activity.this);
            dlog.setTitle("종료");
            dlog.setView(findlog);
            dlog.setPositiveButton("확인", null);
            dlog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(Menu_Activity.this, "프로그램을 종료하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            dlog.show();
        }
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
                layout.setBackgroundColor(Color.BLACK);
                title.setTextColor(Color.WHITE);
                txtname.setTextColor(Color.WHITE);
                txtphone.setTextColor(Color.WHITE);
                txtloc.setTextColor(Color.WHITE);
                txtemail.setTextColor(Color.WHITE);

                name.setTextColor(Color.WHITE);
                phone.setTextColor(Color.WHITE);
                location_edit.setTextColor(Color.WHITE);
                email.setTextColor(Color.WHITE);
                return true;
            case R.id.menu2:
                layout.setBackgroundColor(Color.parseColor("#008891"));
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
    }/*contextmenu fin*/
}

