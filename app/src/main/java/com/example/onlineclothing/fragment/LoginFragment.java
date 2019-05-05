package com.example.onlineclothing.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineclothing.DashboardActivity;
import com.example.onlineclothing.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    private EditText txtusername,txtpassword;
    private Button btnlogin;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        txtusername=view.findViewById(R.id.txtusername);
        txtpassword=view.findViewById(R.id.txtpassword);
        btnlogin=view.findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(validate()){
            checkUser();
        }

    }
    private boolean validate(){
        boolean checkvalidate=true;
        if(TextUtils.isEmpty(txtusername.getText().toString())){
            txtusername.setError("Username is required");
            txtusername.requestFocus();
            checkvalidate=false;
        }
        if(TextUtils.isEmpty(txtpassword.getText().toString())){
            txtpassword.setError("Password is required");
            txtpassword.requestFocus();
            checkvalidate=false;
        }
        return  checkvalidate;

    }
    private void checkUser(){
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("User",MODE_PRIVATE);
        String Username=sharedPreferences.getString("username","");
        String Password=sharedPreferences.getString("password","");
        if(Username.equals(txtusername.getText().toString()) && Password.equals(txtpassword.getText().toString())){

            Toast.makeText(getActivity(),"Successfull ",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getActivity(), DashboardActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(getActivity(),"Either Username or Password is Incorrect ",Toast.LENGTH_SHORT).show();
        }

    }


}
