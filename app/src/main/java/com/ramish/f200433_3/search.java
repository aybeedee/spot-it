package com.ramish.f200433_3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class search extends AppCompatActivity {
    List<items> ItemsArray;

    searchResultAdapter adapter;
    EditText searchBox;

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        rv = findViewById(R.id.searchResultsRecyclerView);
        searchBox = findViewById(R.id.search_box);
        ItemsArray=new ArrayList<>();
        ItemsArray.add(new items("DELL computer"));
        ItemsArray.add(new items("Samsung smartphone"));
        ItemsArray.add(new items("Sony headphones"));
        ItemsArray.add(new items("LG monitor"));
        ItemsArray.add(new items("HP laptop"));
        ItemsArray.add(new items("Apple iPhone"));
        ItemsArray.add(new items("Logitech mouse"));
        ItemsArray.add(new items("Microsoft keyboard"));
        ItemsArray.add(new items("Asus router"));
        ItemsArray.add(new items("Acer monitor"));

        adapter = new searchResultAdapter(search.this , ItemsArray);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(search.this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        // Add a TextWatcher to the search box
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterItems(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
    public void open_search(View view){
        Intent intent=new Intent(
                search.this,
                search.class);
        startActivity(intent);
    }
    public void Open_add_item(View view){
        Intent intent=new Intent(
                search.this,
                add_item.class);
        startActivity(intent);
    }
    public void OpenChat(View view){
        Intent intent=new Intent(
                search.this,
                inbox.class);
        startActivity(intent);
    }
    public void OpenProfile(View view){
        Intent intent=new Intent(
                search.this,
                my_profile.class);
        startActivity(intent);
    }
    public void OpenDashboard(View view){
        Intent intent=new Intent(
                search.this,
                dashboard.class);
        startActivity(intent);
    }
    private void filterItems(String searchText) {
        ArrayList<items> filteredItems = new ArrayList<>();

        for (items item : ItemsArray) {
            if (item.getName().toLowerCase().startsWith(searchText.toLowerCase())) {
                filteredItems.add(item);
            }
        }

        adapter.setFilteredList(filteredItems);

        if (filteredItems.isEmpty()) {
            rv.setVisibility(View.GONE);
        } else {
            rv.setVisibility(View.VISIBLE);
        }
    }
}