package com.example.wangmaobo.gisprimarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.esri.arcgisruntime.mapping.ArcGISScene;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.Camera;
import com.esri.arcgisruntime.mapping.view.SceneView;

public class D3DActivity extends AppCompatActivity {
    private SceneView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d3_d);
        mMapView = findViewById(R.id.mapView);
        initMap();
    }

    private void initMap() {
        if (mMapView != null) {
            //经纬度
            double latitude = 33.8210;
            double longitude = -118.6778;
            //高度
            double altitude = 44000.0;
            double heading = 0.1;
            double pitch = 30.0;
            double roll = 0.0;

            ArcGISScene scene = new ArcGISScene();
            scene.setBasemap(Basemap.createStreets());
            mMapView.setScene(scene);
            Camera camera = new Camera(latitude, longitude, altitude, heading, pitch, roll);
            mMapView.setViewpointCamera(camera);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null != mMapView) {
            mMapView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null != mMapView) {
            mMapView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        if (null != mMapView) {
            mMapView.dispose();
        }
        super.onDestroy();
    }
}
