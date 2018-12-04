package com.levionsoftware.lib.ratingbottomsheetlib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;

public class RatingBottomSheet extends BottomSheetDialogFragment {
    private View mMainView;
    private Short mRating = null;
    private IRatingConfirmedListener mRatingConfirmedListener = null;

    public void setRating(Short rating) {
        mRating = rating;

        refreshRating();
    }

    public void setOnInputConfirmedListener(IRatingConfirmedListener ratingConfirmedListener) {
        mRatingConfirmedListener = ratingConfirmedListener;
    }

    public Short getRating() {
        return mRating;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainView = inflater.inflate(R.layout.rating, container);

        bind();

        return mMainView;
    }

    private void bind() {
        refreshRating();

        // Listener
        RatingBar ratingBar = mMainView.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (!fromUser)
                    return;

                ratingBar.setEnabled(false);

                mRatingConfirmedListener.onInputConfirmed((short) rating);
            }
        });
    }

    private void refreshRating() {
        if(mMainView != null) {
            RatingBar ratingBar = mMainView.findViewById(R.id.ratingBar);
            if (ratingBar != null && mRating != null) {
                ratingBar.setRating(mRating);
            }
        }
    }
}
