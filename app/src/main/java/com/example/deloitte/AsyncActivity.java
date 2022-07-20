package com.example.deloitte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.deloitte.whowroteit.FetchBook;

public class AsyncActivity extends AppCompatActivity {
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
}