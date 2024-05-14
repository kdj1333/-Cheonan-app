package com.Y.OnTheGo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
public class IntroActivity extends Activity {
 @Override
 protected void onCreate(Bundle savedInstanceState){
 requestWindowFeature(Window.FEATURE_NO_TITLE);
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_intro);
 Handler handler = new Handler();
 //실행 딜레이 처리
 handler.postDelayed(new Runnable() {
 @Override
 public void run() {
 Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
 startActivity(intent);
 finish();
 }
 },3500);
 }
 @Override
 protected void onPause(){
 super.onPause();
 finish();
 }
}