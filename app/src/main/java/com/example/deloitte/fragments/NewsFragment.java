package com.example.deloitte.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.deloitte.R;

public class NewsFragment  extends Fragment {
    TextView tvNews;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

         View view = inflater.inflate(R.layout.fragment_news, container,false);
         tvNews = view.findViewById(R.id.tvNews);
        return view;
    }

    public void updateTextview(String headline) {
        tvNews.setText(headline);
    }
}
