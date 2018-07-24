package com.example.admin.drinkingwater;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.sqrt;

public class ImageDisplay extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private Bitmap bitmap;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        Intent i = getIntent();
        Bitmap bit = (Bitmap) i.getExtras().get("bit");

        imageView = findViewById(R.id.imgCam);
        imageView.setImageBitmap(bit);

        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache(true);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE){

                    bitmap = imageView.getDrawingCache();
                    int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    textView.setBackgroundColor(Color.rgb(r,g,b));
                    textView.setText("R("+r+")\n"+"G("+g+")\n"+"B("+b+")");
                    int [] comp = new int[13];
                    int [] [] arr = {{192, 23, 88},
                            {209, 57, 77},
                            {209, 90, 48},
                            {222, 121, 53},
                            {220, 170, 71},
                            {201, 183, 39},
                            {180, 184, 61},
                            {80, 143, 79},
                            {72, 127, 67},
                            {45, 95, 73},
                            {43, 88, 68},
                            {0, 79, 86},
                            {25, 59, 92},
                            {0, 39, 70}
                    };
                    int i = 0;
                    while(i<13){
                        int v1= arr[i][0];
                        int v2= arr[i] [1];
                        int v3 = arr[i] [2];
                        int d= (int)sqrt((r-v1)*(r-v1) + (g-v2)*(g-v2) + (b-v3)*(b-v3) );
                        comp[i]= d;
                        i++;

                    }

                    int a = smallIndex(comp)+1;
                    Toast.makeText(ImageDisplay.this, String.valueOf(a), Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });

    }
    public  int smallIndex (int [] arr1){//start method

        int index = 0;
        int min = arr1[index];
        for (int i=1; i<arr1.length; i++){

            if (arr1[i] < min ){
                min = arr1[i];
                index = i;
            }


        }
        return index ;

    }
    }
