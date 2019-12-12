package com.eddy.materialdesign.ui.bottomnavigation.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddy.materialdesign.R;
import com.eddy.materialdesign.ui.recyclerview.Item;
import com.eddy.materialdesign.ui.recyclerview.ItemAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DashboardFragment extends Fragment {

    private Item[] items = {new Item("Item A", R.drawable.background1), new Item("Item B", R.drawable.background2),
            new Item("Item C", R.drawable.background3), new Item("Item D", R.drawable.background4),
            new Item("Item E", R.drawable.background5), new Item("Item F", R.drawable.background6)};

    private List<Item> itemList = new ArrayList<>();
    private ItemAdapter adapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_bottomnav_dashboard, container, false);

        initItems();
        recyclerView = root.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        return root;
    }

    private void initItems() {
        itemList.clear();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int index = random.nextInt(items.length);
            itemList.add(items[index]);
        }
    }
}