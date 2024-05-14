package com.Y.OnTheGo;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.overlay.PathOverlay;
import java.util.Arrays;
public class Restaurant01_Course extends Activity implements OnMapReadyCallback, 
Overlay.OnClickListener {
 private MapView mapView;
 private static NaverMap naverMap;
//마커 변수 선언 및 초기화
 private Marker marker1 = new Marker();
 private Marker marker2 = new Marker();
 private Marker marker3 = new Marker();
 private Marker marker4 = new Marker();
 //Infowindow 변수 선언 및 초기화
 private InfoWindow infoWindow1 = new InfoWindow();
 private InfoWindow infoWindow2 = new InfoWindow();
 private InfoWindow infoWindow3 = new InfoWindow();
 private InfoWindow infoWindow4 = new InfoWindow();
 //PathOverlay(단일경로) 변수 선언 및 초기화
 private PathOverlay path = new PathOverlay();
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 requestWindowFeature(Window.FEATURE_NO_TITLE);
 getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
 WindowManager.LayoutParams.FLAG_FULLSCREEN);
 super.onCreate(savedInstanceState);
 setContentView(R.layout.restaurant01_course);
 //맵 뷰어
 mapView = findViewById(R.id.map_view);
 mapView.onCreate(savedInstanceState);
 mapView.getMapAsync(this);
 }
 //초기 위치 설정
 @Override
 public void onMapReady(@NonNull NaverMap naverMap) {
 this.naverMap = naverMap;
 path.setCoords(Arrays.asList(
 new LatLng(36.840001, 127.181618),
 new LatLng(36.839151, 127.179827),
 new LatLng(36.839057, 127.178636),
 new LatLng(36.838473, 127.177949)
 ));
 path.setMap(naverMap);
 CameraPosition cameraPosition = new CameraPosition(
 new LatLng(36.839092, 127.182839), // 위치 지정
 13 // 줌 레벨
 );
 infoWindow1.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
 @NonNull @Override
 public CharSequence getText(@NonNull InfoWindow infoWindow) {
 return "AA 음식점\n타꼬야끼 정식집\n000-000-0000";
}
 });
 infoWindow2.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
 @NonNull @Override
 public CharSequence getText(@NonNull InfoWindow infoWindow) {
 return "AA 까페\n000-000-0000";
 }
 });
 infoWindow3.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
 @NonNull @Override
 public CharSequence getText(@NonNull InfoWindow infoWindow) {
 return "AA 공원\n000-000-0000";
 }
 });
 infoWindow4.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
 @NonNull @Override
 public CharSequence getText(@NonNull InfoWindow infoWindow) {
 return "AA 영화관\n000-000-0000";
 }
 });
 setMarker(marker1, 36.840001, 127.181618, R.drawable.ic_baseline_place_25, 
0, "AA 음식점");
 marker1.setOnClickListener(this);
 setMarker(marker2, 36.839151, 127.179827, R.drawable.ic_baseline_place_25, 
0, "AA 까페");
 marker2.setOnClickListener(this);
 setMarker(marker3, 36.839057, 127.178636, R.drawable.ic_baseline_place_25, 
0, "AA 공원");
 marker3.setOnClickListener(this);
 setMarker(marker4, 36.838473, 127.177949, R.drawable.ic_baseline_place_25, 
0, "AA 영화관");
 marker4.setOnClickListener(this);
 naverMap.setCameraPosition(cameraPosition);
 }
 //마커에 정보창 표기
 @Override
 public boolean onClick(@NonNull Overlay overlay) {
 Marker marker = (Marker) overlay;
 infoWindow1.open(marker1);
 infoWindow2.open(marker2);
 infoWindow3.open(marker3);
infoWindow4.open(marker4);
 return false;
 }
/*
 @Override
 public void onMapClick(@NonNull PointF pointF, @NonNull LatLng latLng) {
 if (infoWindow1.getMarker() != null) {
 infoWindow1.close();
 }
 }
*/
 //마커 설정 함수
 private void setMarker(Marker marker, double lat, double lng, int resourceID, 
int zIndex, String info) {
 //원근감 표시 (비활성화)
// marker.setIconPerspectiveEnabled(true);
 //아이콘 지정
 marker.setIcon(OverlayImage.fromResource(resourceID));
 //마커의 투명도
 marker.setAlpha(0.8f);
 //마커 위치
 marker.setPosition(new LatLng(lat, lng));
 //마커 우선순위
 marker.setZIndex(zIndex);
 //마커 표시
 marker.setMap(naverMap);
 //마커 텍스트
 marker.setCaptionText(info);
 //마커의 캡션 너비를 200픽셀로 제한
 marker.setCaptionRequestedWidth(200);
 }
 @Override
 public void onStart() {
 super.onStart();
 mapView.onStart();
 }
 @Override
 public void onResume() {
 super.onResume();
 mapView.onResume();
 }
 @Override
 public void onPause() {
 super.onPause();
mapView.onPause();
 }
 @Override
 public void onStop() {
 super.onStop();
 mapView.onStop();
 }
 @Override
 protected void onDestroy() {
 super.onDestroy();
 mapView.onDestroy();
 }
 @Override
 public void onSaveInstanceState(Bundle outState) {
 super.onSaveInstanceState(outState);
 mapView.onSaveInstanceState(outState);
 }
 @Override
 public void onLowMemory() {
 super.onLowMemory();
 mapView.onLowMemory();
 }
}