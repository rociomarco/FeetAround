package com.example.rosiomarco.projectsummer;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GetNearbyPlacesData extends AsyncTask<Object, String, String>{

    String googlePlacesData;
    GoogleMap mMap;
    String url;

    @Override
    protected String doInBackground(Object... params) {
        try {
            Log.d("GetNearbyPlacesData", "DoInBackground entered");
            mMap = (GoogleMap) params[0];
            url = (String) params[1];
            DownloadUrl downloadUrl = new DownloadUrl();
            googlePlacesData = downloadUrl.readURl(url);
            Log.d("GooglePlacesReadTask", "doInBackground Exit");
        } catch (Exception e) {
            Log.d("GooglePlacesRead Task", e.toString());
        }
        return googlePlacesData;
    }

    @Override
    protected void onPostExecute (String result){
        Log.d("GooglePlacesReadTask", "onPostExecute Entered");
        List<HashMap<String, String>> nearbyPlacesList = null;
        DataParser dataParser = new DataParser();
        nearbyPlacesList =  dataParser.parse(result);
        showNearbyPlaces(nearbyPlacesList);
        Log.d("GooglePlacesReadTask", "onPostExecute Exit");
    }

    private void showNearbyPlaces(List<HashMap<String,String>> nearbyPlaceList)
    {
        for (int i = 0; i < nearbyPlaceList.size(); i++) {
            Log.d("onPostExecute","Entered into showing locations");
            MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String, String> googlePlace = nearbyPlaceList.get(i);
            double lat = Double.parseDouble(googlePlace.get("lat"));
            double lng = Double.parseDouble(googlePlace.get("lng"));
            String placeName = googlePlace.get("place_name");
            String vicinity = googlePlace.get("vicinity");
            LatLng latLng = new LatLng(lat, lng);
            markerOptions.position(latLng);
            markerOptions.title(placeName + " : " + vicinity);

            if (placeName.equals("restaurant"))
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_restaurant));
            else if (placeName.equals("bar"))
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_bar));
            else  if (placeName.equals("store"))
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_store));
            else  if (placeName.equals("gas_station"))
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_gas));
            else  if (placeName.equals("cafe"))
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_cafe));
            else
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_restaurant));

            mMap.addMarker(markerOptions);

            //move map camera
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
        }
    }
}
