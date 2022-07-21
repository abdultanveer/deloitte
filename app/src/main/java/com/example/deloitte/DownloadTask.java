package com.example.deloitte;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
//what are generic classes -- input type, progresstype,result type

public class DownloadTask extends AsyncTask<String,Integer, Bitmap> {
public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar progressBar;
    public DownloadTask(ProgressBar mProgressBar) {
        progressBar = mProgressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override //this method will execute on a seperate background thread
    protected Bitmap doInBackground(String... urlString) {
        Log.i(TAG,"downloading from"+urlString[0]);
        for(int i=1; i<21; i++) {
            try {
                Thread.sleep(300);
                publishProgress(i*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        super.onProgressUpdate(progress);
        progressBar.setProgress(progress[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
