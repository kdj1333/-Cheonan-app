package com.Y.OnTheGo;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 ImageView Restaurant01 = (ImageView) findViewById(R.id.Restaurant01);
 ImageView Restaurant02 = (ImageView) findViewById(R.id.Restaurant02);
 ImageView Restaurant03 = (ImageView) findViewById(R.id.Restaurant03);
 ImageView Restaurant04 = (ImageView) findViewById(R.id.Restaurant04);
 ImageView Restaurant05 = (ImageView) findViewById(R.id.Restaurant05);
 ImageView Restaurant06 = (ImageView) findViewById(R.id.Restaurant06);
 ImageView maps_imageview01 = (ImageView) 
findViewById(R.id.maps_imageView01);
 View.OnClickListener listener = new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 switch (v.getId())
 {
 case R.id.Restaurant01:
 Intent intent = new Intent(MainActivity.this, 
com.Y.OnTheGo.Restaurant01.class);
 startActivity(intent);
break;
 case R.id.Restaurant02:
 //식당마다 같은 코드를 넣어야하기 때문에 생략했습니다.
 break;
 case R.id.Restaurant03:
 //식당마다 같은 코드를 넣어야하기 때문에 생략했습니다.
 break;
 case R.id.Restaurant04:
 //식당마다 같은 코드를 넣어야하기 때문에 생략했습니다.
 break;
 case R.id.Restaurant05:
 //식당마다 같은 코드를 넣어야하기 때문에 생략했습니다.
 break;
 case R.id.Restaurant06:
 //식당마다 같은 코드를 넣어야하기 때문에 생략했습니다.
 break;
 case R.id.maps_imageView01:
 Intent intent07 = new Intent(MainActivity.this, 
MapsActivity.class);
 startActivity(intent07);
 break;
 }
 }
 };
 Restaurant01.setOnClickListener(listener);
 Restaurant02.setOnClickListener(listener);
 Restaurant03.setOnClickListener(listener);
 Restaurant04.setOnClickListener(listener);
 Restaurant05.setOnClickListener(listener);
 Restaurant06.setOnClickListener(listener);
 maps_imageview01.setOnClickListener(listener);
 }
}