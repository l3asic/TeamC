package com.example.totproject.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.totproject.R;
import com.example.totproject.iot.IotDTO;
import com.example.totproject.party.PartyListDTO;
import com.google.android.material.snackbar.Snackbar;

import net.daum.mf.map.api.CalloutBalloonAdapter;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapReverseGeoCoder;
import net.daum.mf.map.api.MapView;

import java.io.IOException;
import java.util.List;

public class KakaoMapActivity extends AppCompatActivity implements MapView.MapViewEventListener
        , MapReverseGeoCoder.ReverseGeoCodingResultListener
        , MapView.POIItemEventListener {

        CustomCalloutBalloonAdapter adapter;
        MapPOIItem marker;
        TextView tv_refresh_location;
        TextView tv_nowlocation;
final int ADDR_REQ_CODE = 1001;
        MapView mapView;
        MapPoint mapPoints;
        double latitude ;
        double longitude ;

        IotDTO dto;

public String defaultAddr = "";

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kakao_act_map);

        Intent getIntent = getIntent();
        dto = (IotDTO) getIntent.getSerializableExtra("dto");
        latitude = dto.getIot_x();
        longitude = dto.getIot_y();



        mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        marker = new MapPOIItem();
        tv_nowlocation = findViewById(R.id.tv_nowlocation);
        mapPoints = MapPoint.mapPointWithGeoCoord(latitude, longitude);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude), true);
        mapView.setZoomLevel(2, true);

        /*=========================마커생성하는 부분================================*/
        marker.setTag(0);
        marker.setItemName("마지막 위치");
        marker.setMapPoint(mapPoints);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        adapter = new CustomCalloutBalloonAdapter();
        mapView.setCalloutBalloonAdapter(adapter);
        mapView.addPOIItem(marker);
        mapView.setMapViewEventListener(this);
        mapView.setPOIItemEventListener(this);
        mapView.selectPOIItem(marker, true);
        /*=========================================================*/
        tv_nowlocation.setText(defaultAddr);

        changeLocation();

        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(KakaoMapActivity.this);

        builder.setTitle("위치 확인").setMessage("마지막 위치를 확인 하셨습니까?\n"
        + defaultAddr);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
        finish();
        }
        });
        AlertDialog alertDialog = builder.create();

        alertDialog.show();
        }
        });


        }

public void changeLocation(){
        //주석 된 부분은 현재 위치를 받아 와야할때 사용할것
        //final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        requestStoragePermission(mapView);
        return;
        }
        // Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //latitude = location.getLatitude();
        //longitude = location.getLongitude();
        changeMarker(MapPoint.mapPointWithGeoCoord(latitude , longitude) );
        }



class CustomCalloutBalloonAdapter implements CalloutBalloonAdapter {
    private final View mCalloutBalloon;

    public CustomCalloutBalloonAdapter() {
        mCalloutBalloon = getLayoutInflater().inflate(R.layout.custom_callout_balloon, null);
    }

    @Override
    public View getCalloutBalloon(MapPOIItem poiItem) {
        ((TextView) mCalloutBalloon.findViewById(R.id.title)).setText(poiItem.getItemName());

        return mCalloutBalloon;
    }

    @Override
    public View getPressedCalloutBalloon(MapPOIItem poiItem) {
        return null;
    }
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==ADDR_REQ_CODE && resultCode == RESULT_OK){

            String addrs = data.getStringExtra("addr");
            Geocoder geocoder = new Geocoder(KakaoMapActivity.this);
            try {
                List<Address> list = null;
                list = geocoder.getFromLocationName(
                        addrs, // 지역 이름
                        10); // 읽을 개수
                if(list != null){

                    changeMarker( MapPoint.mapPointWithGeoCoord(list.get(0).getLatitude() , list.get(0).getLongitude()));
                    MapReverseGeoCoder reverseGeoCoder = new MapReverseGeoCoder("a7f164cc9022f1143cd1b1f544d66920",
                            MapPoint.mapPointWithGeoCoord(list.get(0).getLatitude() , list.get(0).getLongitude()),
                            this,
                            KakaoMapActivity.this); reverseGeoCoder.startFindingAddress();
                }else{

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onMapViewInitialized(MapView mapView) {

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onReverseGeoCoderFoundAddress(MapReverseGeoCoder mapReverseGeoCoder, String s) {
        defaultAddr = s ;
        tv_nowlocation.setText(s);
        mapView.selectPOIItem(marker , true);
        latitude = mapPoints.getMapPointGeoCoord().latitude;
        longitude = mapPoints.getMapPointGeoCoord().longitude;
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude , longitude) , true);
        mapView.setZoomLevel(2, true);
        marker.setTag(0);
        marker.setMapPoint(mapPoints);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.selectPOIItem(marker , true);

    }

    @Override
    public void onReverseGeoCoderFailedToFindAddress(MapReverseGeoCoder mapReverseGeoCoder) {

    }

    public void changeMarker(MapPoint mapPoint){

        mapPoints = mapPoint ;
        MapReverseGeoCoder reverseGeoCoder = new MapReverseGeoCoder("a7f164cc9022f1143cd1b1f544d66920",
                mapPoint,
                this,
                KakaoMapActivity.this); reverseGeoCoder.startFindingAddress();
        reverseGeoCoder.startFindingAddress();
        //marker.setDraggable(true);
    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }












    int[] permissionInt = {
            1001,1002
    };
    String[] permissions ={
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    int index = 0;

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i = 0; i < permissionInt.length; i++) {
            if (requestCode == permissionInt[i]) {
                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(getApplicationContext(), "FAILED!", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        }

    }

    protected void requestStoragePermission(View view) {
        for(int i = 0 ; i < permissions.length ; i ++) {
            index = i;
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[i])) {
                Snackbar.make(view, "Write permission is required to save image to gallery", Snackbar.LENGTH_INDEFINITE)
                        .setAction(android.R.string.ok, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ActivityCompat.requestPermissions(KakaoMapActivity.this, new String[]{permissions[index]}, permissionInt[index]);
                            }
                        }).show();
            } else {
                Toast.makeText(getApplicationContext(), "Permission Required!", Toast.LENGTH_SHORT)
                        .show();
                ActivityCompat.requestPermissions(KakaoMapActivity.this, new String[]{permissions[index]}, permissionInt[index]);
            }
        }
    }

}