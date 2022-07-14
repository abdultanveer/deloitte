package com.example.deloitte;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LanguageAdapter  extends RecyclerView.Adapter<LanguageAdapter.LangViewHolder> {
    public static String TAG = LanguageAdapter.class.getSimpleName();

    @NonNull
    @Override
    public LangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG,"yatish has bought a new row plank from market");
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_plank,parent,false);
        return new LangViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull LangViewHolder holderKshitij, int position) {
        Log.i(TAG, "akshita is writing the dish name on the row plank");
        holderKshitij.rowTextView.setText("language");
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "sharnali is counting the no of data items");
        return 0;
    }

    public class LangViewHolder extends RecyclerView.ViewHolder {
        TextView rowTextView;
        public LangViewHolder(@NonNull View rowViewYatish) {
            super(rowViewYatish);
            Log.i(TAG, "kshitij is putting the plank in viewholder box");
            rowViewYatish = rowViewYatish.findViewById(R.id.tvRowPlank);
        }
    }
}
