package com.eddy.materialdesign.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.eddy.materialdesign.R;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private MaterialButtonToggleGroup buttonGroup;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        buttonGroup = root.findViewById(R.id.toggle_button_group);

        buttonGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                //Toast.makeText(getActivity(), checkedId+","+isChecked, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "changed", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}