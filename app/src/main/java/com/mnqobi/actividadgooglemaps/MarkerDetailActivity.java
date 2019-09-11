package com.mnqobi.actividadgooglemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MarkerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_detail);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Extraer lat. y lng.
        Intent intent = getIntent();
        @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String latlng = String.format(
                getString(R.string.marker_detail_latlng),
                intent.getDoubleExtra(MainActivity.EXTRA_LATITUD, 0),
                intent.getDoubleExtra(MainActivity.EXTRA_LONGITUD, 0));
        // Poblar
        TextView coordenadas = (TextView) findViewById(R.id.tv_latlng);
        coordenadas.setText(latlng);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
