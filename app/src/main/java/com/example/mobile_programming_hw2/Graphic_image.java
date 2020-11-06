package com.example.mobile_programming_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;


public class Graphic_image extends AppCompatActivity {
    ImageButton zoomIn, zoomOut, Rotate, Blur, Bright;
    Button Emboss;
    SeekBar seekBar;

    GraphicView graphicView;

    static float scaleX = 1;
    static float scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static int state = 1;
    static int stateEmboss = 11;


    public static Paint setBlur(Paint p) {
        /*blur*/
        BlurMaskFilter bMask;
        bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
        p.setMaskFilter(bMask);
        return p;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_image);
        setTitle("포토샵");

        seekBar = findViewById(R.id.seek);
        LinearLayout picLayout = findViewById(R.id.pictureLayout);
        zoomIn = findViewById(R.id.zoom_in);
        zoomOut = findViewById(R.id.zoom_out);
        Rotate = findViewById(R.id.rotate);
        Bright = findViewById(R.id.bright);
        Blur = findViewById(R.id.blur);
        Emboss = findViewById(R.id.emboss);

        graphicView = new GraphicView(this);
        picLayout.addView(graphicView);
        clickIcons();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                color = i - 50;
                Toast.makeText(Graphic_image.this, "밝기: " + color, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void clickIcons() {
        zoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX += 0.2f;
                scaleY += 0.2f;
                graphicView.invalidate();
            }
        });
        zoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX -= 0.2f;
                scaleY -= 0.2f;
                graphicView.invalidate();
            }
        });
        Rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle += 20;
                graphicView.invalidate();
            }
        });
        Bright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar.setVisibility(View.VISIBLE);
            }
        });
        Blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = 0;
                graphicView.invalidate();
            }
        });
        Emboss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stateEmboss = 111;
                graphicView.invalidate();

            }
        });

    }

    private static class GraphicView extends View {

        public GraphicView(Context context) {
            super(context);
        }

        @SuppressLint("DrawAllocation")
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            @SuppressLint("DrawAllocation")
            Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.jongro);
            int picX = (this.getWidth() - pic.getWidth()) / 4;
            int picY = (this.getHeight() - pic.getHeight()) / 4;

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;

            @SuppressLint("DrawAllocation") Paint paint = new Paint();
            float[] array = {
                    color, 0, 0, 0, 0,
                    0, color, 0, 0, 0,
                    0, 0, color, 0, 0,
                    0, 0, 0, 1, 0
            };
            /*밝기*/
            @SuppressLint("DrawAllocation") ColorMatrix cm = new ColorMatrix(array);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            /*blur*/
            if (state == 0) {
                setBlur(paint);
            }
            if (stateEmboss == 111) {
                EmbossMaskFilter eMask;
                eMask = new EmbossMaskFilter(new float[]{3, 3, 10}, 0.5f, 5, 10);
                paint.setMaskFilter(eMask);
            }

            /*canvas*/
            canvas.rotate(angle, cenX, cenY);
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.drawBitmap(pic, picX, picY, paint);

            pic.recycle();
        }
    }
}