package com.example.deloitte;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.deloitte.whowroteit.FetchBook;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class AsyncActivity extends AppCompatActivity {
    public static String TAG = "AsyncActivity";
            //AsyncActivity.class.getSimpleName();
    ProgressBar mProgressBar;
    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        mProgressBar = findViewById(R.id.progressBar);

        mBookInput = (EditText)findViewById(R.id.bookInput);
        mTitleText = (TextView)findViewById(R.id.titleText);
        mAuthorText = (TextView)findViewById(R.id.authorText);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //registerReceiver(new SmsReceiver(),new IntentFilter().addAction(););
    }

    @Override
    protected void onStop() {
        super.onStop();
        /*
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage("5556",null,"happy birthday",null,null);*/

        // unregisterReceiver();
    }

    public void downloadHandler(View view) {
        DownloadTask downloadTask = new DownloadTask(mProgressBar);
        downloadTask.execute("https://www.imageurltodownload.com");
    }

    public void searchBooks(View view) {
        // Get the search string from the input field.
        String queryString = mBookInput.getText().toString();
        FetchBook fetchBook = new FetchBook(mTitleText,mAuthorText);
        fetchBook.execute(queryString);
    }

    public void fcmHandler(View view) {

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(
                new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        // val token: String = task.getResult().toString()
                        String token = task.getResult().toString();
                        Log.i(TAG,"token is--"+token);

                    }
                }
        );
    }
}