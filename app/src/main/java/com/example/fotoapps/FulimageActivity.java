package com.example.fotoapps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;

public class FulimageActivity extends AppCompatActivity {
    ImageView fulimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fulimage);
        fulimage = findViewById(R.id.ful_image);

        String imageUriStr = getIntent().getStringExtra("image");
        Uri imageUri = Uri.parse(imageUriStr);

        try{
            InputStream imageStream = getContentResolver().openInputStream(imageUri);
            Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            fulimage.setImageBitmap(selectedImage);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}