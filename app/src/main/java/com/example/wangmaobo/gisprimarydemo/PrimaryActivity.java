
package com.example.wangmaobo.gisprimarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class PrimaryActivity extends AppCompatActivity {
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);
        mMapView = findViewById(R.id.mapView);
        initMap();
    }

    private void initMap() {
        if (mMapView != null) {
            //风格，枚举类-提供了18种风格
            Basemap.Type basemapType = Basemap.Type.STREETS_NIGHT_VECTOR;
            //经纬度
            double latitude = 34.09042;
            double longitude = -118.71511;
            //清晰度
            int levelOfDetail = 11;
            ArcGISMap map = new ArcGISMap(basemapType, latitude, longitude, levelOfDetail);
            mMapView.setMap(map);
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
