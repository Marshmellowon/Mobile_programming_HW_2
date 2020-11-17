package com.example.mobile_programming_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        brand = findViewById(R.id.brand);
        gallery = findViewById(R.id.gal);

        Gallery gallery1;
        gallery1 = new Gallery(this);


        Spinner();
    }

    public class Gallery extends BaseAdapter {
        Context context;
        Integer[] brand = {
                R.drawable.adidas, R.drawable.carhatt,
                R.drawable.imnot, R.drawable.cov,
                R.drawable.markgon
        };

        public Gallery(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return brand.length;
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

            imageView.setImageResource(brand[i]);
            return imageView;
        }
    }

    public void Spinner() {
        String[] brandSpinner = {"covernat", "vivastudio"};

        ArrayAdapter<String> brandList;

        brandList = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brandSpinner);
        brand.setAdapter(brandList);

        brand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MyGridView Adapter;
                Viva viva;

                viva = new Viva(Adapter_View.this);
                if (brand.getItemAtPosition(i).equals("covernat")) {
                    Adapter = new MyGridView(Adapter_View.this);
                    gV.setAdapter(Adapter);
                } else if (brand.getItemAtPosition(i).equals("vivastudio")) {
                    viva = new Viva(Adapter_View.this);
                    gV.setAdapter(viva);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public static class MyGridView extends BaseAdapter {
        Context context;


        Integer[] covernat = {
                R.drawable.pic1, R.drawable.pic2,
                R.drawable.pic3, R.drawable.pic4,
                R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8
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

    public static class Viva extends BaseAdapter {
        Context context;
        Integer[] viva = {
                R.drawable.viv1, R.drawable.viv2,
                R.drawable.viv3, R.drawable.viv4,
                R.drawable.viv5, R.drawable.viv6,
                R.drawable.viv7, R.drawable.viv8,
        };

        public Viva(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return viva.length;
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

            imageView.setImageResource(viva[i]);
            return imageView;
        }
    }
}