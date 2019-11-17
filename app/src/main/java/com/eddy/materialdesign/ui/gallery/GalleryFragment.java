package com.eddy.materialdesign.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.eddy.materialdesign.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private Button alertDialog1, alertDialog2, alertDialog3, alertDialog4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        alertDialog1 = root.findViewById(R.id.material_button1);
        alertDialog2 = root.findViewById(R.id.material_button2);
        alertDialog3 = root.findViewById(R.id.material_button3);
        alertDialog4 = root.findViewById(R.id.material_button4);

        alertDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Ok", null)
                        .show();
            }
        });

        alertDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Ok", null)
                        .show();
            }
        });

        alertDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Ok", null)
                        .show();
            }
        });

        alertDialog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog)
                        .setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Ok", null)
                        .show();
            }
        });


        return root;
    }
}