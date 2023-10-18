package com.ramish.f200433_3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class searchResultAdapter extends RecyclerView.Adapter<searchResultAdapter.ViewHolder>  {
    Context context;
    private List<items> searchResults;

    public searchResultAdapter(Context context,List<items> searchResults) {
        this.searchResults = searchResults;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_rv_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.itemNameTextView.setText(searchResults.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemNameTextView;
        LinearLayout ll1;

        public ViewHolder(View view) {
            super(view);
            itemNameTextView = view.findViewById(R.id.itemName);
            ll1=view.findViewById(R.id.rv_search);
        }
    }

    public void setFilteredList(ArrayList<items> filteredItems) {
        this.searchResults = filteredItems;
        notifyDataSetChanged();
    }
}
