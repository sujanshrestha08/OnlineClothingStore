package com.example.onlineclothing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class ItemAddActivity extends AppCompatActivity {
    private EditText txtname,txtprice,txtimage,txtdesc;
    private Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        txtname=findViewById(R.id.txtname);
        txtprice=findViewById(R.id.txtprice);
        txtimage=findViewById(R.id.txtimage);
        txtdesc=findViewById(R.id.txtdesc);
        btnadd=findViewById(R.id.btnsave);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    save();
                }
            }
        });

    }
    private void  save(){
        try{
            PrintStream printStream= new PrintStream(openFileOutput("items.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(txtname.getText().toString()+"->"+txtprice.getText().toString()+"->"+txtimage.getText().toString()+"->"+txtdesc.getText().toString());
            printStream.flush();
            printStream.close();
            Toast.makeText(this,"saved to "+getFilesDir(),Toast.LENGTH_LONG).show();
Intent intent=new Intent(ItemAddActivity.this,DashboardActivity.class);
            startActivity(intent);
        }catch (IOException e){
            Log.d("Items Add ","Error"+e.toString());
            e.printStackTrace();

        }
    }
    private boolean validate(){
        boolean checkvalidate=true;
        if(TextUtils.isEmpty(txtname.getText().toString())){
            txtname.setError(" Name is required");
            txtname.requestFocus();
            checkvalidate=false;
        }
        if(TextUtils.isEmpty(txtprice.getText().toString())){
            txtprice.setError("Price is required");
            txtprice.requestFocus();
            checkvalidate=false;
        }
        if(TextUtils.isEmpty(txtimage.getText().toString())){
            txtimage.setError("Image is required");
            txtimage.requestFocus();
            checkvalidate=false;
        }
        if(TextUtils.isEmpty(txtdesc.getText().toString())){
            txtdesc.setError("Description is required");
            txtdesc.requestFocus();
            checkvalidate=false;
        }


        return  checkvalidate;

    }
}
