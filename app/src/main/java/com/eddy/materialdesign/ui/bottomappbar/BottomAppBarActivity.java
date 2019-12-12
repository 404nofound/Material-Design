package com.eddy.materialdesign.ui.bottomappbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddy.materialdesign.R;
import com.eddy.materialdesign.ui.recyclerview.Item;
import com.eddy.materialdesign.ui.recyclerview.ItemAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BottomAppBarActivity extends AppCompatActivity {

    private Item[] items = {new Item("Item A", R.drawable.background1), new Item("Item B", R.drawable.background2),
            new Item("Item C", R.drawable.background3), new Item("Item D", R.drawable.background4),
            new Item("Item E", R.drawable.background5), new Item("Item F", R.drawable.background6)};

    private List<Item> itemList = new ArrayList<>();
    private ItemAdapter adapter;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);

        BottomAppBar bar = findViewById(R.id.bar);
        setSupportActionBar(bar);

        fab = findViewById(R.id.fab);

        initItems();
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the navigation click by showing a BottomDrawer etc.
                finish();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(0, items[0]);
                recyclerView.scrollToPosition(0);
            }
        });
    }

    private void initItems() {
        itemList.clear();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int index = random.nextInt(items.length);
            itemList.add(items[index]);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_basic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "CLicked Item 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "CLicked Item 2", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
