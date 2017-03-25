package com.example.marius.nasapictureoftheday;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    IotdHandler handler = new IotdHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler.processFeed();
        resetDisplay(handler.getTitle(),handler.getDate(), handler.getImage(), handler.getDescription().toString());

    }

    private void resetDisplay(String title, String date, Bitmap image, String description){
        TextView titleView = (TextView) findViewById(R.id.title);
        TextView dateView = (TextView) findViewById(R.id.dateOfPublication);
        ImageView imageView = (ImageView) findViewById(R.id.imageDisplay);
        TextView descriptionView = (TextView) findViewById(R.id.description);

        titleView.setText(title);
        dateView.setText(date);
        descriptionView.setText(description);
        imageView.setImageBitmap(image);
    }
}
