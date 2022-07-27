package com.example.deloitte.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.deloitte.R;

public class FragmentActivity extends AppCompatActivity implements HeadlinesFragment.OnHeadlinesSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    public void onHeadlineSelected(String headline, int position) {
        NewsFragment newsFragment = (NewsFragment) getSupportFragmentManager().findFragmentById(R.id.newsFrag);
        newsFragment.updateTextview(headline);
        Toast.makeText(this,"frag activity --"+ headline, Toast.LENGTH_SHORT).show();

    }
}