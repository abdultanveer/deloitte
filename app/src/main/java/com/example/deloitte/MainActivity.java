package com.example.deloitte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int a; //declaration
    Student deloiteStudent; //declaration
    EditText nameEditText; //declaration
    TextView mainTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

          a = 5; //initialization
        setContentView(R.layout.activity_main); //inflating --layout inflater
        nameEditText = findViewById(R.id.etName); //initialization -- taking handle
        mainTextView = findViewById(R.id.tvMain);
        deloiteStudent = new Student(); //instantiation
        deloiteStudent.setName("yatish");

    }

    public void clickHandler(View view) {
        //get the text from edittext
        String name = nameEditText.getText().toString();
        //set the text into the textview
        mainTextView.setText(name);
        // Toast.makeText(this, "logging in", Toast.LENGTH_SHORT).show();
        /*Intent hIntent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(hIntent);*/
    }

    void drawRectangle(int length, int breadth){}

    int add(int fno, int sno){
        return fno+sno;
    }
}