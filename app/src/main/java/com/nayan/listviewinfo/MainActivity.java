package com.nayan.listviewinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.nayan.listviewinfo.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText eTUsername, eTPhoneNo, eTEmail, eTCgpa;
    ArrayList<Student> studentArrayList;
    ArrayAdapter<Student> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }

    private void initialization() {
        eTUsername = findViewById(R.id.editTextUserName);
        eTPhoneNo = findViewById(R.id.editTextPhone);
        eTEmail = findViewById(R.id.editTextEmail);
        eTCgpa = findViewById(R.id.editTextCgpa);

        studentArrayList = new ArrayList<>();
        adapter = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1,
                studentArrayList);

    }

    public void saveData(View view) {
        boolean error = false;
        Float cgpa = null;
        String userName = eTUsername.getText().toString();
        String phoneNo = eTPhoneNo.getText().toString();
        String email = eTEmail.getText().toString();
        String cgpaStr = eTCgpa.getText().toString();

        if(userName.isEmpty()){
            eTUsername.setError("Username is missing!");
            error = true;
        }else{
            if(userName.length()<6){
                eTUsername.setError("Username is too short!");
                error = true;
            }
        }
        if(phoneNo.isEmpty()){
            eTPhoneNo.setError("Phone No is required!");
            error = true;
        }else if(phoneNo.length()==11){
            if(phoneNo.startsWith("017") || phoneNo.startsWith("019") || phoneNo.startsWith("018")){

            }else{
                eTPhoneNo.setError("Phone No is not valid!");
                error = true;
            }
        }else{
            eTPhoneNo.setError("Phone No should be 11 digit!");
            error = true;
        }
        if(email.isEmpty()){
            eTEmail.setError("Email is missing!");
            error = true;
        }else if(email.length()>30){
            eTEmail.setError("Email should have max 30 characters!");
            error = true;
        }
        if(cgpaStr.isEmpty()){
            eTCgpa.setError("CGPA is missing!");
        }else{
            cgpa = Float.parseFloat(cgpaStr);
            if(cgpa<4.0 && cgpa>0){

            }else{
                eTCgpa.setError("CGPA should be within 4.0!");
            }
        }
    }


}
