# Android Rating Bottom Sheet
=============================

[![](https://jitpack.io/v/DennyWeinberg/android-ratingbottomsheet.svg)](https://jitpack.io/#DennyWeinberg/android-ratingbottomsheet)

It's an Android Material Design Rating Bottom Sheet using AndroidX Architecture.

![Preview](assets/preview.png?raw=true "Preview")

Download
--------

```gradle
repositories {
  maven { url ‘https://jitpack.io’ }
}

dependencies {
  implementation 'com.github.DennyWeinberg:android-ratingbottomsheet:1.0.0'
}
```

Usage
-----

```final RatingBottomSheet rbs = new RatingBottomSheet();
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
rbs.show(getSupportFragmentManager(), null);```
