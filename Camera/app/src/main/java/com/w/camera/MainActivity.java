package com.w.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static int REQUEST_MAIN = 8888;
    private Button btnCamera;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = findViewById(R.id.btn_camera);
        img = findViewById(R.id.img);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_MAIN & resultCode == RESULT_OK){
            Bitmap pic = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(pic);
        }
    }

    private void openCamera(){
        Intent intentCamera = new Intent(
                MediaStore.ACTION_IMAGE_CAPTURE
        );
        startActivityForResult(intentCamera, REQUEST_MAIN);

    }
}
