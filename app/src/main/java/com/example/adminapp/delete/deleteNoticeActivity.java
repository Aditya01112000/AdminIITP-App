package com.example.adminapp.delete;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class deleteNoticeActivity extends AppCompatActivity {

    private RecyclerView deleteNoticeRecycler;
    private ProgressBar progressBar;
    private ArrayList<NoticeData> list;
    private DatabaseReference reference;
    private NoticeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_notice);
        deleteNoticeRecycler=findViewById(R.id.deleteNoticeRecycler);
        progressBar=findViewById(R.id.progressBar);
        reference= FirebaseDatabase.getInstance().getReference().child("Notice");
        deleteNoticeRecycler.setLayoutManager(new LinearLayoutManager(this));
        deleteNoticeRecycler.setHasFixedSize(true);
        getNotice();
    }

    private void getNotice() {
       reference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               list = new ArrayList<>();
               for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                   NoticeData data = dataSnapshot.getValue(NoticeData.class);
                   list.add(data);
               }
               adapter=new NoticeAdapter(deleteNoticeActivity.this,list);
               adapter.notifyDataSetChanged();
               progressBar.setVisibility(View.GONE);
               deleteNoticeRecycler.setAdapter(adapter);

           }
           @Override
           public void onCancelled(@NonNull DatabaseError error) {
               progressBar.setVisibility(View.GONE);
               Toast.makeText(deleteNoticeActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
           }
       });
    }
}