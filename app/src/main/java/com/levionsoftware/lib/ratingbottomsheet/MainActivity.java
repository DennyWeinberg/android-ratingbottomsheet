package com.levionsoftware.lib.ratingbottomsheet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.levionsoftware.lib.ratingbottomsheet.lib.IRatingConfirmedListener;
import com.levionsoftware.lib.ratingbottomsheet.lib.RatingBottomSheet;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.testButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RatingBottomSheet rbs = new RatingBottomSheet();
                rbs.setRating(new Short("3"));
                rbs.setOnInputConfirmedListener(new IRatingConfirmedListener() {
                    @Override
                    public void onInputConfirmed(final short rating) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                rbs.dismiss();
                                Toast.makeText(MainActivity.this, "Rating: " + String.valueOf(rating), Toast.LENGTH_SHORT).show();
                            }
                        }, 200);
                    }
                });

                rbs.show(getSupportFragmentManager(), null);
            }
        });
    }
}
