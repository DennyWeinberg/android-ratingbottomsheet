package com.levionsoftware.lib.ratingbottomsheet.lib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.levionsoftware.lib.ratingbottomsheet.R;

import androidx.annotation.NonNull;

public class RatingBottomSheet extends BottomSheetDialogFragment {
    private Short mRating = null;
    private IRatingConfirmedListener mRatingConfirmedListener = null;

    public void setRating(Short rating) {
        mRating = rating;
    }

    public void setOnInputConfirmedListener(IRatingConfirmedListener ratingConfirmedListener) {
        mRatingConfirmedListener = ratingConfirmedListener;
    }

    public Short getRating() {
        return mRating;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rating, container);

        bind(view);

        return view;
    }

    private void bind(View view) {
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);

        // Init rating
        if (mRating != null) {
            ratingBar.setRating(mRating);
        }

        // Listener
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
}
