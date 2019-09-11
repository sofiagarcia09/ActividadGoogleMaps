package com.mnqobi.actividadgooglemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener{
    private FirstMapFragment mFirstMapFragment;
    private final int LOCATION_REQUEST_CODE = 0;
    private GoogleMap gMap;
    private Marker markerPais;
    private LatLng latLng;
    static String EXTRA_LATITUD;
    static String EXTRA_LONGITUD;

    //public static final  int LOCALTION_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"MAIN",Toast.LENGTH_LONG).show();

        mFirstMapFragment = FirstMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map, mFirstMapFragment)
                .commit();
        mFirstMapFragment.getMapAsync(this); //registrar la aplicacion como escucha
    }

    @Override
    public void onMapReady(GoogleMap googleMap) { //Carga el mapa

        gMap = googleMap;

        //MARCADOR EN UNA POSICION
        /*LatLng miCasa = new LatLng(19.42667,-100.35269);
        googleMap.addMarker(new MarkerOptions() //el metodo addMarker añade un marcador(icono)que apunta a la posicion indicada por la longitud y latitud
        .position(miCasa)
        .title("Casa de Sofía"));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(miCasa)
                .zoom(10)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition)); //movimiento de la camara */

        //HABILITAR O DESABILITAR GESTOS
        /*UiSettings uiSettings = googleMap.getUiSettings(); //La clase UiSettings configura las características de interfaz de usuario de la clase GoogleMap.
        uiSettings.setScrollGesturesEnabled(false); //modifica la disponibilidad de desplazamiento
        uiSettings.setTiltGesturesEnabled(false); //modifica la disponibilidad de inclinación
        uiSettings.setZoomGesturesEnabled(false);// modifica la disponibilidad de gestos de zoom
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
              new LatLng(40.3839, -100.9565), 2)); */



        //CONTROLES UI SOBRE EL MAPA

       /* UiSettings uiSettings = gMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true); //botones de zoom
        //gMap.addMarker(new MarkerOptions().position((new LatLng(0,0))));
        uiSettings.setCompassEnabled(true); //Brujula
        uiSettings.setMapToolbarEnabled(true); //herramienta google maps

        //checkSelfPermission es un metodo para comprobar si la aplicacion tiene acceso a los permisos
        //Para checar si la aplicacion tiene el permiso de acceso a la ubicacion
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            //si no tiene el permiso lo solicitamos
            ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        LOCATION_REQUEST_CODE);
        }else{
            Toast.makeText(this,"El permiso ha sido otorgado",Toast.LENGTH_LONG).show();
            gMap.setMyLocationEnabled(true);
        }*/
    //MARCKERS O MARCADORES EN GOOGLE MAPS

        //MARCKER DEFINIDO EN JAPON
       /* LatLng latLng = new LatLng(36.2048, 138.2529); //Coordenadas de Japon
        gMap.addMarker(new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.person))
                .title("Japón")
                .draggable(true)
                .snippet("Primer ministro: Shinzō Abe")
        );
        gMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));*/


        //EVENTOS AL CLIKEAR UN MARCADOR
        latLng = new LatLng(20.8661000, -100.4010900); //Coordenadas de Mexico
        markerPais = gMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("México")
        );
        //camara
        gMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        //eventos
        gMap.setOnMarkerClickListener(this);


    }

    //cuando el usuario responde la osolicitud el sistma invoca a este metodo para notificar al usuario
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == LOCATION_REQUEST_CODE){
            //si la peticion es cancelada
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //si el permiso ha sido asignado activamos la ubicacion
                gMap.setMyLocationEnabled(true);
            }else{
                Toast.makeText(this,"Error de permisos",Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if (marker.equals(latLng)) {
            Intent intent = new Intent(this, MarkerDetailActivity.class);
            intent.putExtra(EXTRA_LATITUD, marker.getPosition().latitude);
            intent.putExtra(EXTRA_LONGITUD, marker.getPosition().longitude);
            startActivity(intent);
        }
        return false;
    }
}