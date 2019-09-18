package com.mnqobi.actividadgooglemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMarkerDragListener, GoogleMap.OnInfoWindowClickListener, AdapterView.OnItemSelectedListener,
        GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    private FirstMapFragment mFirstMapFragment;
    private final int LOCATION_REQUEST_CODE = 0;
    private GoogleMap gMap;
    private Marker markerPais;
    private LatLng latLng = new LatLng(20.8661000, -100.4010900);
    static String LATITUD;
    static String EXTRA_LONGITUD;
    private Marker markerArgentina;
    private SupportMapFragment mMapFragment;
    private Spinner mMapTypeSelector;
    //TIPOS DE MAPAS
    private int mMapTypes[] = {
            GoogleMap.MAP_TYPE_NONE,
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_SATELLITE,
            GoogleMap.MAP_TYPE_HYBRID,
            GoogleMap.MAP_TYPE_TERRAIN };


    //public static final  int LOCALTION_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this,"MAIN",Toast.LENGTH_LONG).show();

        mFirstMapFragment = FirstMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map, mFirstMapFragment)
                .commit();
        mFirstMapFragment.getMapAsync(this); //registrar la aplicacion como escucha


   /*//TIPOS DE MAPAS
        mMapTypeSelector = findViewById(R.id.map_type_selector);
        mMapTypeSelector.setOnItemSelectedListener(this);

        mMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);*/


    }

    @Override
    public void onMapReady(GoogleMap googleMap) { //Carga el mapa

        gMap = googleMap;

        //MARCADOR EN UNA POSICION
        LatLng miCasa = new LatLng(19.42667,-100.35269);
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
        //latLng = new LatLng(20.8661000, -100.4010900); //Coordenadas de Mexico
        /*markerPais = gMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("México")
        );
        //camara
        gMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        //eventos
        gMap.setOnMarkerClickListener(this);*/


        //EVENTOS PARA ARRASTRAR UN MARCKER
       /* latLng = new LatLng(20.8661000, -100.4010900); //Coordenadas de Mexico
        markerPais = googleMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("México")
                .draggable(true) );

        gMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        gMap.setOnMarkerDragListener(this);*/

       //EVENTOS SOBRE LA INFO WINDOW
       /* LatLng argentina = new LatLng(-34.6, -58.4);
        markerArgentina = googleMap.addMarker(
                new MarkerOptions()
                        .position(argentina)
                        .title("Argentina") );
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(argentina));
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);
        googleMap.setOnInfoWindowClickListener(this);*/
        //markerArgentina.remove();


        //Mover camara del mapa
        //gMap.moveCamera(CameraUpdateFactory.zoomBy(20)); //aumentar el zoom en 20 unidades al iniciar el mapa
        //Cambiar la ubicacion hacia nicaragua y aunmentar 7 nivele de zoom
        /*LatLng nicaragua = new LatLng(13, -85);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nicaragua, 7));
        //con un desplazamiento de 100 pixeles a la derecha y 200 hacia arriba
        gMap.moveCamera(CameraUpdateFactory.scrollBy(100,-200));*/


        //PERSONALIZAR LA POSICION DE LA CAMARA
        //Ubicar la camara apuntando a España......
       /* LatLng españa = new LatLng(40.416667, -3.75);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(españa)
                .zoom(7)
                .bearing(90)
                .tilt(90)
                .build();
        gMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));*/

        //CREAR FORMAS CON GOOGLE MAPS
        // Ejemplo: Delimitar a Sudamérica con un rectángulo
       /* PolylineOptions sudamericaRect = new PolylineOptions()
                .add(new LatLng(12.897489, -82.441406)) // P1
                .add(new LatLng(12.897489, -32.167969)) // P2
                .add(new LatLng(-55.37911, -32.167969)) // P3
                .add(new LatLng(-55.37911, -82.441406)) // P4
                .add(new LatLng(12.897489, -82.441406)) // P1
                .color(Color.parseColor("#f44336"));    // Rojo 500

        Polyline polyline = gMap.addPolyline(sudamericaRect);
        gMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(-20.96144,-61.347656)));*/

        //Encerrar a Cuba con un polígono de bajo detalle
        /*LatLng p1 = new LatLng(21.88661065803621, -85.01541511562505);
        LatLng p2 = new LatLng(22.927294359193038, -83.76297370937505);
        LatLng p3 = new LatLng(23.26620799401109, -82.35672370937505);
        LatLng p4 = new LatLng(23.387267854439315, -80.79666511562505);
        LatLng p5 = new LatLng(22.496957602618004, -77.98416511562505);
        LatLng p6 = new LatLng(20.20512046753661, -74.16092292812505);
        LatLng p7 = new LatLng(19.70944706110937, -77.65457527187505);

        Polygon cubaPolygon = gMap.addPolygon(new PolygonOptions()
                .add(p1, p2, p3, p4, p5, p6, p7, p1)
                .strokeColor(Color.parseColor("#AB47BC"))
                .fillColor(Color.parseColor("#7B1FA2")));

        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(21.5034305704608, -78.95096199062505), 5));*/

        //CREAR CIRCULOs

       /* LatLng center = new LatLng(3.4003755294523828, -76.54801384952702);
        int radius = 40;

        CircleOptions circleOptions = new CircleOptions()
                .center(center)
                .radius(radius)
                .strokeColor(Color.parseColor("#0D47A1"))
                .strokeWidth(4)
                .fillColor(Color.argb(32, 33, 150, 243));

        Circle circle = gMap.addCircle(circleOptions);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 17));*/


       //Eventos sobre el mapa
        //gMap.setOnMapClickListener(this);

        //eventos con click prolongado
        // Configuración UI
        //gMap.getUiSettings().setAllGesturesEnabled(false);
        // Eventos
        //gMap.setOnMapLongClickListener(this);
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
    public boolean onMarkerClick(final Marker marker) {

        //Nos envia a otra actividad las coordenadas del marker
        /*Toast.makeText(this,""+marker.getPosition(),Toast.LENGTH_LONG).show();

        if (marker.getPosition().equals(latLng)) {
            double lat  = marker.getPosition().latitude;
            double lon = marker.getPosition().longitude;
            Toast.makeText(this,"Latitud: "+lat + " Longitud: "+lon,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), MarkerDetailActivity.class);
            intent.putExtra(LATITUD, lat);
            intent.putExtra(EXTRA_LONGITUD, lon);
            startActivity(intent);
        }
        return false;*/

        if (marker.getPosition().equals(markerArgentina.getPosition())) {
            gMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()),
                    new GoogleMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    Intent intent = new Intent(MainActivity.this, MarkerDetailActivity.class);
                    intent.putExtra(LATITUD, marker.getPosition().latitude);
                    intent.putExtra(EXTRA_LONGITUD, marker.getPosition().longitude);
                    startActivity(intent);
                }
                @Override
                public void onCancel() {

                }
            });
            return true;
        }
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

        if (marker.getPosition().equals(markerPais.getPosition())) {
            Toast.makeText(this, "START", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if(marker.getPosition().equals(markerPais)){
            String newTitulo=String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlngD),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);

            setTitle(newTitulo);
        }

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if (marker.getPosition().equals(markerPais.getPosition())) {
            Toast.makeText(this, "END", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        if (marker.equals(markerArgentina)) {
            ArgentinaDialogFragment.newInstance(marker.getTitle(),
                    getString(R.string.argentina_full_snippet))
                    .show(getSupportFragmentManager(), null);     }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        gMap.setMapType(mMapTypes[i]);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.add("Inicio").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence title = item.getTitle();
        if (title != null && title.equals("Inicio")) {
            LatLng zero = new LatLng(80, 80);
            gMap.animateCamera(
                    CameraUpdateFactory.newLatLng(zero), // update
                    2000, // durationMs
                    new GoogleMap.CancelableCallback() { // callback
                        @Override
                        public void onFinish() {
                            Toast.makeText(MainActivity.this, "Animación finalizada",Toast.LENGTH_LONG).show();
                        }
                        @Override
                        public void onCancel() {
                            }
                    });
        }     return super.onOptionsItemSelected(item);
}


    @Override
    public void onMapClick(LatLng latLng) {
        String formatLatLng = String.format(Locale.getDefault(),
                "Lat/Lng = (%f,%f)", latLng.latitude, latLng.longitude);
        Point screentPoint = gMap.getProjection().toScreenLocation(latLng);
        String formatScreenPoint = String.format(Locale.getDefault(),
                "\nPoint = (%d,%d)", screentPoint.x, screentPoint.y);
        Toast.makeText(this, formatLatLng + formatScreenPoint, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        // Añadir marker en la posición
        Marker marker = gMap.addMarker(new MarkerOptions().position(latLng));
        // Obtener pixeles reales
        Point point = gMap.getProjection().toScreenLocation(latLng);
        // Determinar el ancho total de la pantalla
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int width = display.widthPixels;
        float hue;
        // ¿La coordenada de pantalla es menor o igual que la mitad del ancho?
        if (point.x <= width / 2) {
            hue = BitmapDescriptorFactory.HUE_YELLOW;
        } else {
            hue = BitmapDescriptorFactory.HUE_ORANGE;
        }
        // Cambiar color del marker según el grupo
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(hue));
    }
}