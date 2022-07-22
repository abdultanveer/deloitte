package com.example.deloitte;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    public  static String DATA_KEY = "lugTag";
    public static String TAG = MainActivity.class.getSimpleName();
    int a; //declaration
    Student deloiteStudent; //declaration --ref on stack memory
    EditText nameEditText,etPassword; //declaration
    TextView mainTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //retaining the old defination

          a = 5; //initialization
        setContentView(R.layout.activity_main); //inflating --layout inflater
        nameEditText = findViewById(R.id.etName); //initialization -- taking handle
        mainTextView = findViewById(R.id.tvMain);
        etPassword = findViewById(R.id.etPassword);

        nameEditText.setOnFocusChangeListener(this);
        deloiteStudent = new Student(); //instantiation -- heap memory
        deloiteStudent.setName("yatish");

        Log.i(TAG,"onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
        storeData();

    }

    private void storeData() {
        //get the data from edittext
        String name = nameEditText.getText().toString();
        String pass = etPassword.getText().toString();
        //create teh file
        SharedPreferences preferences = getSharedPreferences("deloitte_prefs",MODE_PRIVATE);
        //open the file in edit mode
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString("namekey",name);
        editor.putString("passkey",pass);
        //save the file
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG,"onResume");
        restoreData();
    }

    private void restoreData() {
        //get the file
        SharedPreferences preferences = getSharedPreferences("deloitte_prefs",MODE_PRIVATE);
        //read from the file
        String name = preferences.getString("namekey","");
        String password = preferences.getString("passkey","");
        //put the data back into edittexts
        nameEditText.setText(name);
        etPassword.setText(password);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
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
        int d = add(10,20);
        //set the text into the textview
        mainTextView.setText(name);
        // Toast.makeText(this, "logging in", Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this,HomeActivity.class); //explicit intent
       // hIntent.putExtra(DATA_KEY,name); //key-value pair --- Map

        //startActivityForResult(hIntent,123);
        throw new NullPointerException("couldn't start home activity");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK){
            String contact = data.getExtras().getString("ckey");
            mainTextView.setText(contact);
        }
    }

    void drawRectangle(int length, int breadth){}

    int add(int fno, int sno){
        return fno+sno;
    }

    @Override
    public void onFocusChange(View view, boolean isFocussed) {
        if(isFocussed){
            Toast.makeText(this, "focussed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "lost focus", Toast.LENGTH_SHORT).show();

        }
    }

    public void implicitHandler(View view) {
        Intent cIntent = new Intent("yatish.khsitij.sharnali.akshita");//somebody ill
        startActivity(cIntent);
    }
}