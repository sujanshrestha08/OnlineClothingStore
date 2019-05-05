package com.example.onlineclothing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.onlineclothing.adapter.ClothAdapter;
import com.example.onlineclothing.model.Cloth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnadd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        recyclerView=findViewById(R.id.recyclerview);
        btnadd=findViewById(R.id.btnAdd);

        List<Cloth> clothlist = new ArrayList<>();
        try {
            FileInputStream fos = openFileInput("items.txt");
            InputStreamReader isr=new InputStreamReader(fos);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while ((line=br.readLine())!=null){
                String[] parts=line.split("->");



                int image= getResources().getIdentifier(parts[2],"drawable",getPackageName());
                clothlist.add(new Cloth(parts[0],parts[1],image,parts[3]));
}

            ClothAdapter clothesadapter=new ClothAdapter(this,clothlist);
            recyclerView.setAdapter(clothesadapter);
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        }  catch (IOException e) {
            e.printStackTrace();
        }

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DashboardActivity.this,ItemAddActivity.class);
                startActivity(intent);

            }
        });


    }
}
