package com.example.kwt.graycam;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kwt.graycam.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    Drawable drawable;
    Bitmap bitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);

        drawable = ContextCompat.getDrawable(this,R.drawable.mway);
        bitmap = ((BitmapDrawable) drawable).getBitmap();
        Bitmap newBitmap = convertImage(bitmap);
        imageView.setImageBitmap(newBitmap);

    }

    public static Bitmap convertImage(Bitmap original)
    {
        Bitmap finalImage =Bitmap.createBitmap(original.getWidth(),
                original.getHeight(), original.getConfig());

        int A,R,G,B;
        int colorPixel;
        int width = original.getWidth();
        int height = original.getHeight();

        for(int x = 0; x < height; x++)
        {
            for(int y = 0; y < width; y++)
            {
                colorPixel = original.getPixel(x, y);
                A = Color.alpha(colorPixel);
                R = Color.red(colorPixel);
                G = Color.green(colorPixel);
                B = Color.blue(colorPixel);

                R = (R+G+B)/3;
                G = R;
                B = R;

                finalImage.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        return finalImage;
    }


}
