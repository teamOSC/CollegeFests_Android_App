package com.teamosc.collegefests.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.teamosc.collegefests.R;

/**
 * Created by omerjerk on 26/1/14.
 */
public class ReachUsFragment extends Fragment {

    /**
     * The Map object
     */
    private GoogleMap mMap;

    public static ReachUsFragment newInstance(String param1, String param2) {
        ReachUsFragment fragment = new ReachUsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ReachUsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_reach_us, container, false);

        mMap = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        /*
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                //TODO: Don't know. Blank for now.
                }
        });*/

        MarkerOptions markerOptions;
        LatLng position;

        markerOptions = new MarkerOptions();
        //Couldn't think of a better solution for now
        position = new LatLng(Double.parseDouble(getString(R.string.latitude_reach_us)),
                Double.parseDouble(getString(R.string.longitude_reach_us)));
        markerOptions.position(position);
        markerOptions.title(getString(R.string.title_marker_reach_us));
        mMap.addMarker(markerOptions);

        return rootView;
    }
}
