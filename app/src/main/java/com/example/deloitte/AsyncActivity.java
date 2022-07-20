package com.example.deloitte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        mProgressBar = findViewById(R.id.progressBar);
    }


    public void downloadHandler(View view) {
        DownloadTask downloadTask = new DownloadTask(mProgressBar);
        downloadTask.execute("https://www.imageurltodownload.com");
    }
}