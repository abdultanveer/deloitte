package com.example.deloitte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {
String[] languages = new String[]{"english","hindi","urdu","tamil","telgu","malyalam","marathi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LanguageAdapter adapter = new LanguageAdapter(languages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}