package com.mnqobi.actividadgooglemaps;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

public class FirstMapFragment extends SupportMapFragment {


    public FirstMapFragment() {
        // Required empty public constructor
    }

    public static FirstMapFragment newInstance() {
        return new FirstMapFragment();
    }




    public static FirstMapFragment newInstance(String param1, String param2) {
        FirstMapFragment fragment = new FirstMapFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vistaMaps = super.onCreateView(inflater, container, savedInstanceState);
        return vistaMaps;
    }

}
