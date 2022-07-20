package com.example.deloitte;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
//what are generic classes -- input type, progresstype,result type

public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar progressBar;
    public DownloadTask(ProgressBar mProgressBar) {
        progressBar = mProgressBar;
    }

    @Override //this method will execute on a seperate background thread
    protected Bitmap doInBackground(String... urlString) {
        Log.i(TAG,"downloading from"+urlString[0]);
        publishProgress(50);
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        progressBar.setProgress(progress[0]);
    }
}
