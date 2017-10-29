## Using FusedLocationProviderClient
- Find your current location using FusedLocationProviderClient
- [Add in Google LBS API  version 11](https://developers.google.com/android/reference/com/google/android/gms/location/FusedLocationProviderClient)
## Be sure to read(AndroidMenifest.xml)
```
<meta-data android:name="com.google.android.geo.API_KEY"       
            android:value="GoogleMap Key"/>
```

## build.gradle(App module)
```
compile 'com.google.android.gms:play-services-location:11.4.2'
compile 'com.google.android.gms:play-services-maps:11.4.2'
```
