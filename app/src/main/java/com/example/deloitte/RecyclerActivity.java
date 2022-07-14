package com.example.deloitte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RecyclerActivity extends AppCompatActivity {
String[] languages = new String[]{"english","hindi","urdu","tamil","telgu","malyalam","marathi"
,"english","hindi","urdu","tamil","telgu","malyalam","marathi"
,"english","hindi","urdu","tamil","telgu","malyalam","marathi",
        "english","hindi","urdu","tamil","telgu","malyalam","marathi",
        "english","hindi","urdu","tamil","telgu","malyalam","marathi",
        "english","hindi","urdu","tamil","telgu","malyalam","marathi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LanguageAdapter adapter = new LanguageAdapter(languages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        Button contextButton = findViewById(R.id.btnContext);
        registerForContextMenu(contextButton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater myMenuInflater = getMenuInflater();
        myMenuInflater.inflate(R.menu.recycler_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch (item.getItemId()){
             case R.id.miSettings:
                 Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                 break;
             case R.id.miLogout:
                 Toast.makeText(this, "logging out", Toast.LENGTH_SHORT).show();

                 break;
         }
        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.recycler_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
         super.onContextItemSelected(item);

        switch (item.getItemId()){
            case R.id.miEdit:
                Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miDelete:
                Toast.makeText(this, "deleting", Toast.LENGTH_SHORT).show();

                break;
            case R.id.miShare:
                Toast.makeText(this, "sharing", Toast.LENGTH_SHORT).show();

                break;
        }
        return true;
    }
}