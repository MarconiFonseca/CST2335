package com.example.androidlabs;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity{
    static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String ACTIVITY_NAME = "ProfileActivity";
    private ImageButton mImageButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            //setContentView(R.layout.activity_main_relative);
            //setContentView(R.layout.activity_main_grid);
            //setContentView(R.layout.activity_main_linear);
            setContentView(R.layout.profileactivity);
            Intent intent = getIntent();
            String email = intent.getStringExtra("email");
             mImageButton = (ImageButton)findViewById(R.id.imageButton);

            // Switch to StartActivity
            EditText enteremail = (EditText) findViewById(R.id.EnterYourEmail);
            enteremail.setText(email);

            final ImageButton button = (ImageButton) findViewById(R.id.imageButton);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    dispatchTakePictureIntent();
                    // your handler code here

                }
            });




        }
            private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }



    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(ACTIVITY_NAME, "in onResume()");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(ACTIVITY_NAME, "in onStart()");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i(ACTIVITY_NAME, "in onPause()");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i(ACTIVITY_NAME, "in onStop()");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "in onDestroy()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
           //mageView mImageButton =null;
            mImageButton.setImageBitmap(imageBitmap);
        }
    }



}

