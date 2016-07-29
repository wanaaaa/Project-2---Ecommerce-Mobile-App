package com.ga.android.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

public class MmDetailActivity extends AppCompatActivity {
    TextView TVtitle, TVprice;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mm_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String price = intent.getStringExtra("price");

        image = (ImageView) findViewById(R.id.detailImage);
//        URL url = new URL("http://g.nordstromimage.com/ImageGallery/store/product/Zoom/2/10945202.jpg");
//        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//        image.setImageBitmap(bmp);

        TVtitle = (TextView) findViewById(R.id.titleInDetail);
        TVprice = (TextView) findViewById(R.id.priceInDetail);

        TVtitle.setText(title);
        TVprice.setText(price);

//       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
