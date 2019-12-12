package com.eddy.materialdesign.ui.widgets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.eddy.materialdesign.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class WidgetsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private MaterialButtonToggleGroup buttonGroup;

    public static WidgetsFragment newInstance(int index) {
        WidgetsFragment fragment = new WidgetsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.viewpager_fragment_widgets, container, false);

        buttonGroup = root.findViewById(R.id.toggle_button_group);

        buttonGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                Toast.makeText(getActivity(), "changed", Toast.LENGTH_SHORT).show();
            }
        });

        final ProgressBar bar = root.findViewById(R.id.progress_bar2);

        new Thread(){
            @Override
            public void run() {
                int i=0;
                while(i<100){
                    i++;
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bar.setProgress(i);
                }
            }
        }.start();

        AdView mAdView = root.findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("87B8E83525FCB69F71AE1154E35EF784").build();
        mAdView.loadAd(adRequest);

        return root;
    }

}



