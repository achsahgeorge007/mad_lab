package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public Boolean validateName(){
        EditText ed1 = (EditText) findViewById(R.id.name);
        String name = ed1.getText().toString();
        if (name.isEmpty()){
            ed1.setError("Name Cannot be Empty");
            return false;
        }
        else {
            return true;
        }
    }
    public  Boolean validateEmail(){
        EditText ed2 = (EditText) findViewById(R.id.email);
        String email = ed2.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.isEmpty()){
            ed2.setError("Email Cannot be Empty");
            return false;
        }
        else if (!email.matches(emailPattern)){
            ed2.setError("Invalid email address");
            return false;
        }
        else{
            return true;
        }
    }
    public  Boolean validateNumber(){
        EditText ed3 = (EditText) findViewById(R.id.phone);
        String num = ed3.getText().toString();
        if (num.isEmpty()){
            ed3.setError("Phone Number Cannot be Empty");
            return false;
        }
        else{
            return true;
        }
    }
    public  Boolean validatePassword(){
        EditText ed4 = (EditText) findViewById(R.id.pswd);
        String pswd = ed4.getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (pswd.isEmpty()){
            ed4.setError("Password Cannot be Empty");
            return false;
        }
        else if (!pswd.matches(passwordVal)) {
            ed4.setError("Password is too weak");
            return false;
        }
        else{
            return true;
        }
    }
    public void onSubmit(View view){
        if(validateName() && validateEmail() && validateNumber() && validatePassword()){
            Toast t = Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG);
            t.show();
        }
    }
}