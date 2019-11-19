package com.eddy.materialdesign.ui.slideshow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;
import androidx.fragment.app.Fragment;

import com.eddy.materialdesign.R;
import com.google.android.material.card.MaterialCardView;

public class SlideshowFragment extends Fragment { //implements
        //View.OnTouchListener {
        //ViewDragHelper.Callback {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private ViewDragHelper mTopViewDragHelper;

    private SlideshowViewModel slideshowViewModel;
    private MaterialCardView cardView;

    public static SlideshowFragment newInstance(int index) {
        SlideshowFragment fragment = new SlideshowFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        cardView = root.findViewById(R.id.card_view);

        mTopViewDragHelper = ViewDragHelper.create(container, 1.0f, new ViewDragHelperCallback());
        //mTopViewDragHelper.
        //mTopViewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_TOP);
        /*final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    /*@Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ObjectAnimator upAnim = ObjectAnimator.ofFloat(view, "translationZ", 16);
                upAnim.setDuration(150);
                upAnim.setInterpolator(new DecelerateInterpolator());
                upAnim.start();
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                ObjectAnimator downAnim = ObjectAnimator.ofFloat(view, "translationZ", 0);
                downAnim.setDuration(150);
                downAnim.setInterpolator(new AccelerateInterpolator());
                downAnim.start();
                break;
        }
        return false;
    }*/



    public class ViewDragHelperCallback extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View v, int i) {
            Log.d("TTT", "work");
            return true;
        }

        @Override
        public void onViewCaptured(@NonNull View capturedChild, int activePointerId) {
            Log.d("TTT", "work1");
            if (capturedChild instanceof MaterialCardView) {
                Log.d("TTT", "work2");
                ((MaterialCardView)cardView).setDragged(true);
            }
        }

        @Override
        public void onViewReleased(@NonNull View releaseChild, float xVel, float yVel) {
            Log.d("TTT", "work3");
            if (releaseChild instanceof MaterialCardView) {
                Log.d("TTT", "work4");
                ((MaterialCardView)cardView).setDragged(false);
            }
        }
    }
}

