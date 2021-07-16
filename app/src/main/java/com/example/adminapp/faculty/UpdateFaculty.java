package com.example.adminapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView csDepartment,eeDepartment,meDepartment,ceDepartment;
    private LinearLayout csNoData,eeNoData,meNoData,ceNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private DatabaseReference reference,dbref;
    private TeacherAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);
        fab=findViewById(R.id.fab);
        csDepartment=findViewById(R.id.csDepartment);
        eeDepartment=findViewById(R.id.eeDepartment);
        meDepartment=findViewById(R.id.meDepartment);
        ceDepartment=findViewById(R.id.ceDepartment);
        csNoData=findViewById(R.id.csNoData);
        eeNoData=findViewById(R.id.eeNoData);
        meNoData=findViewById(R.id.meNoData);
        ceNoData=findViewById(R.id.ceNoData);
        reference= FirebaseDatabase.getInstance().getReference().child("Teachers");
        csDepartment();
        eeDepartment();
        meDepartment();
        ceDepartment();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(UpdateFaculty.this,AddTeachers.class));
            }
        });
    }

    private void csDepartment() {
        dbref=reference.child("Computer Science");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               list1=new ArrayList<>();
               if(!snapshot.exists()){
                   csNoData.setVisibility(View.VISIBLE);
                   csDepartment.setVisibility(View.GONE);
               }
               else{
                   csNoData.setVisibility(View.GONE);
                   csDepartment.setVisibility(View.VISIBLE);
                   for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                       TeacherData data=dataSnapshot.getValue(TeacherData.class);
                       list1.add(data);
                       csDepartment.setHasFixedSize(true);
                       csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                       adapter=new TeacherAdapter(list1,UpdateFaculty.this);
                       csDepartment.setAdapter(adapter);
                   }
               }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eeDepartment() {
        dbref=reference.child("Electrical");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2=new ArrayList<>();
                if(!snapshot.exists()){
                    eeNoData.setVisibility(View.VISIBLE);
                    eeDepartment.setVisibility(View.GONE);
                }
                else{
                    eeNoData.setVisibility(View.GONE);
                    eeDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        TeacherData data=dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                        eeDepartment.setHasFixedSize(true);
                        eeDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                        adapter=new TeacherAdapter(list2,UpdateFaculty.this);
                        eeDepartment.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void meDepartment() {
        dbref=reference.child("Mechanical");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3=new ArrayList<>();
                if(!snapshot.exists()){
                    meDepartment.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }
                else{
                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        TeacherData data=dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                        meDepartment.setHasFixedSize(true);
                        meDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                        adapter=new TeacherAdapter(list3,UpdateFaculty.this);
                        meDepartment.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ceDepartment() {
        dbref=reference.child("Chemical");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4=new ArrayList<>();
                if(!snapshot.exists()){
                    ceDepartment.setVisibility(View.VISIBLE);
                    ceDepartment.setVisibility(View.GONE);
                }
                else{
                    ceNoData.setVisibility(View.GONE);
                    ceDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        TeacherData data=dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                        ceDepartment.setHasFixedSize(true);
                        ceDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                        adapter=new TeacherAdapter(list4,UpdateFaculty.this);
                        ceDepartment.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}