package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.adminapp.delete.NoticeAdapter;
import com.example.adminapp.delete.UploadNotice;
import com.example.adminapp.delete.deleteNoticeActivity;
import com.example.adminapp.faculty.UpdateFaculty;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   CardView uploadNotice;
   CardView addGalleryImage;
   CardView addpdf;
   CardView faculty;
   CardView deleteNotice1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uploadNotice=findViewById(R.id.addNotice);
        addGalleryImage=findViewById(R.id.addGalleryImage);
        addpdf=findViewById(R.id.addEbook);
        faculty=findViewById(R.id.faculty);
        deleteNotice1=findViewById(R.id.deleteNotice1);
       uploadNotice.setOnClickListener(this);
       addGalleryImage.setOnClickListener(this);
       addpdf.setOnClickListener(this);
       faculty.setOnClickListener(this);
       deleteNotice1.setOnClickListener(this);
    }

   @Override
   public void onClick(View v) {
       Intent intent;
     switch (v.getId()) {
         case R.id.addNotice:
              intent = new Intent(MainActivity.this, UploadNotice.class);
              startActivity(intent);
             break;
         case R.id.addGalleryImage:
             intent = new Intent(MainActivity.this, Uploadimage.class);
             startActivity(intent);
             break;
         case R.id.addEbook:
             intent = new Intent(MainActivity.this, uploadPdfActivity.class);
             startActivity(intent);
             break;
         case R.id.faculty:
             intent = new Intent(MainActivity.this, UpdateFaculty.class);
             startActivity(intent);
             break;
         case R.id.deleteNotice1:
             intent = new Intent(MainActivity.this, deleteNoticeActivity.class);
             startActivity(intent);
             break;
     }
   }
}
