package com.example.mapapp11;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MapView map = null;
    private MyLocationNewOverlay locationOverlay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configuration indispensable pour charger les images
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        Configuration.getInstance().setUserAgentValue(getPackageName());

        setContentView(R.layout.activity_main);

        // Demander les permissions
        requestPermissionsIfNecessary(new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        });

        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(15.0);

        // --- POSITION PAR DÉFAUT (Alger) ---
        // On centre ici pour ne plus voir l'océan au démarrage
        GeoPoint algerPoint = new GeoPoint(36.7538, 3.0588);
        mapController.setCenter(algerPoint);

        // Ajouter un marqueur de test
        Marker startMarker = new Marker(map);
        startMarker.setPosition(algerPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        startMarker.setTitle("Alger Centre");
        map.getOverlays().add(startMarker);

        // Activer la localisation réelle
        this.locationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(this), map);
        this.locationOverlay.enableMyLocation();
        this.locationOverlay.enableFollowLocation();
        map.getOverlays().add(this.locationOverlay);
    }

    private void requestPermissionsIfNecessary(String[] permissions) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(permission);
            }
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toArray(new String[0]), 1);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }
}