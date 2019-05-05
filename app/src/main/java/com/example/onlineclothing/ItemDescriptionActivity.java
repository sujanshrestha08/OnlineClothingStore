package com.example.onlineclothing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemDescriptionActivity extends AppCompatActivity {
    CircleImageView imgview;
    TextView txtname,txtprice,txtdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);
        imgview=findViewById(R.id.imgProfile);
        txtname=findViewById(R.id.tvName);
        txtprice=findViewById(R.id.tvPrice);
        txtdesc=findViewById(R.id.tvDesc);


        Bundle bundle =getIntent().getExtras();
        if(bundle !=null){
            imgview.setImageResource(bundle.getInt("image"));
            txtname.setText(bundle.getString("name"));
            txtprice.setText("Nrs. "+bundle.getString("price"));
            txtdesc.setText(bundle.getString("desc"));

        }
    }
}
