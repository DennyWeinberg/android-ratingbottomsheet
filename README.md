# Android Rating Bottom Sheet

[![](https://jitpack.io/v/DennyWeinberg/android-ratingbottomsheet.svg)](https://jitpack.io/#DennyWeinberg/android-ratingbottomsheet)

It's an Android Material Design Rating Bottom Sheet using [Android Jetpack Components (2018)](https://developer.android.com/jetpack/) ([androidx.* package libraries](https://developer.android.com/jetpack/androidx/)) and [Android Material Design Components](https://material.io/develop/android/).

<kbd>![Preview](assets/preview.png?raw=true "Preview")</kbd>

Download
--------

```gradle
repositories {
  maven { url ‘https://jitpack.io’ }
}

dependencies {
  implementation 'com.github.DennyWeinberg:android-ratingbottomsheet:[VERSION/TAG]'
}
```

Usage
-----

    final RatingBottomSheet rbs = new RatingBottomSheet();
    rbs.setRating(new Short("3"));
    rbs.setOnInputConfirmedListener(new IRatingConfirmedListener() {
        @Override
        public void onInputConfirmed(final short rating) {
            rbs.dismiss();
            Toast.makeText(MainActivity.this, "Rating: " + String.valueOf(rating), Toast.LENGTH_SHORT).show();
        }
    });
    rbs.show(getSupportFragmentManager(), null);

Apps using this library
-----------------------
Want to be here? Open an `issue` or make a `pull request`.

<table>
	<tr>
        <td><a href="https://play.google.com/store/apps/details?id=com.levionsoftware.photos"><img src="https://lh3.googleusercontent.com/BgryiDdm8YVUaXbrGJG2PsIy61qBa92sXReVIpRy8y2xZxtU46c0tp2izjdhRcKRgbc=w64"/></a></td>
		<td><a href="https://play.google.com/store/apps/details?id=com.levionsoftware.photos">Levipic - Photo Gallery & Map</a></td>
	</tr>
	<tr>
        <td><a href="https://play.google.com/store/apps/details?id=com.levionsoftware.instagram_map"><img src="https://lh3.googleusercontent.com/QL0QDLXBm9j2Y2An4MOZtlbI02yx_zuI7I3vMBM_mBO_BbimNKjBQeldQBBKo0P60Og=w64"/></a></td>
		<td><a href="https://play.google.com/store/apps/details?id=com.levionsoftware.instagram_map">Photo Map - Photo and Video Gallery</a></td>
</table>
