package com.example.deloitte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public  static String DATA_KEY = "lugTag";
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
        switch (view.getId()){
            case R.id.btnLogin:
                startHome();
                break;
            case R.id.btnCancel:
                startDialer();
                break;
        }

    }

    private void startDialer() {
        Intent dIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:98765432")); //implicit intent
        startActivity(dIntent);
    }

    private void startHome() {
        //get the text from edittext
        String name = nameEditText.getText().toString();
        //set the text into the textview
        mainTextView.setText(name);
        // Toast.makeText(this, "logging in", Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this,HomeActivity.class); //explicit intent
        hIntent.putExtra(DATA_KEY,name); //key-value pair --- Map
        startActivity(hIntent);
    }


    void drawRectangle(int length, int breadth){}

    int add(int fno, int sno){
        return fno+sno;
    }
}