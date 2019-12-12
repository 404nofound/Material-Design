package com.eddy.materialdesign.ui.cardviews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.eddy.materialdesign.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class CardViewFragment extends Fragment implements View.OnClickListener { //implements

    private static final String ARG_SECTION_NUMBER = "section_number";

    private ImageView favour_card2, favour_card3, bookmark_card3;
    private boolean favour2Clicked, favour3Clicked, bookmark3Clicked;

    private ImageView image1, image2_1, image2_2, image3, image4;

    public static CardViewFragment newInstance(int index) {
        CardViewFragment fragment = new CardViewFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.viewpager_fragment_cardviews, container, false);

        favour_card2 = root.findViewById(R.id.img_favorite_cardview_2);
        favour_card3 = root.findViewById(R.id.img_favorite_cardview_3);
        bookmark_card3 = root.findViewById(R.id.img_bookmark_cardview_3);

        image1 = root.findViewById(R.id.img_cardview_1);
        image2_1 = root.findViewById(R.id.small_circle_cardview_2);
        image2_2 = root.findViewById(R.id.img_cardview_2);
        image3 = root.findViewById(R.id.img_cardview_3);
        image4 = root.findViewById(R.id.img_cardview_4);

        Glide.with(getContext()).load(R.drawable.background5).apply(new RequestOptions().fitCenter()).into(image1);
        Glide.with(getContext()).load(R.drawable.background2).apply(new RequestOptions().fitCenter()).into(image2_2);
        Glide.with(getContext()).load(R.drawable.background3).apply(new RequestOptions().fitCenter()).into(image3);
        Glide.with(getContext()).load(R.drawable.background4).apply(new RequestOptions().fitCenter()).into(image4);

        favour_card2.setOnClickListener(this);
        favour_card3.setOnClickListener(this);
        bookmark_card3.setOnClickListener(this);

        RatingBar ratingBar = root.findViewById(R.id.ratingbar_cardview_4);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ratingBar.setRating(v);
            }
        });

        AdView mAdView = root.findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("87B8E83525FCB69F71AE1154E35EF784").build();
        mAdView.loadAd(adRequest);

        return root;
    }

    @Override
    public void onClick(View view) {

        AlphaAnimation alphaAnimationShowIcon = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimationShowIcon.setDuration(500);

        switch (view.getId()) {
            case R.id.img_favorite_cardview_2:
                if (!favour2Clicked) {
                    favour_card2.setImageResource(R.drawable.ic_favorite_black_24dp);
                    favour_card2.startAnimation(alphaAnimationShowIcon);
                    favour2Clicked = true;
                } else {
                    favour_card2.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    favour_card2.startAnimation(alphaAnimationShowIcon);
                    favour2Clicked = false;
                }
                break;
            case R.id.img_favorite_cardview_3:
                if (!favour3Clicked) {
                    favour_card3.setImageResource(R.drawable.ic_favorite_black_24dp);
                    favour_card3.startAnimation(alphaAnimationShowIcon);
                    favour3Clicked = true;
                } else {
                    favour_card3.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    favour_card3.startAnimation(alphaAnimationShowIcon);
                    favour3Clicked = false;
                }
                break;
            case R.id.img_bookmark_cardview_3:
                if (!bookmark3Clicked) {
                    bookmark_card3.setImageResource(R.drawable.ic_bookmark_black_24dp);
                    bookmark_card3.startAnimation(alphaAnimationShowIcon);
                    bookmark3Clicked = true;
                } else {
                    bookmark_card3.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                    bookmark_card3.startAnimation(alphaAnimationShowIcon);
                    bookmark3Clicked = false;
                }
                break;
        }
    }
}

