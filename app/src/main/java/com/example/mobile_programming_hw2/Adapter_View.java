package com.example.mobile_programming_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class Adapter_View extends AppCompatActivity {

    GridView gV;
    Gallery gallery;
    Spinner category, brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter__view);
        setTitle("옷 고르기");

        gV = findViewById(R.id.gridView);

        gallery = findViewById(R.id.gallery);
        MyGridView Adapter = new MyGridView(this);
        gV.setAdapter(Adapter);
        Spinner();
    }

    public void Spinner() {
        String[] brandSpinner = {"covernat", "vivastudio"};

        brand = findViewById(R.id.brand);

        ArrayAdapter<String> brandList;

        brandList = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brandSpinner);
        brand.setAdapter(brandList);

    }

    public static class MyGridView extends BaseAdapter {
        Context context;


        Integer[] covernat = {
                R.drawable.pic1, R.drawable.pic2,
                R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8
        };
        Integer[] viva = {
                R.drawable.viv1, R.drawable.viv2,
                R.drawable.viv3, R.drawable.viv4,
                R.drawable.viv5, R.drawable.viv6,
                R.drawable.viv7, R.drawable.viv8,
        };

        public MyGridView(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return covernat.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(covernat[i]);
            return imageView;
        }
    }
}