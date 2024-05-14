package com.Y.OnTheGo;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MyPage extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 
 //상태바 지우기
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
 WindowManager.LayoutParams.FLAG_FULLSCREEN);
 setContentView(R.layout.activity_mypage);
 TextView mypage_rt03_txt = findViewById(R.id.mypage_rt03_txt);
 LinearLayout mypage_rt01 = findViewById(R.id.mypage_rt01);
 Intent intent = getIntent(); // 넘어온 Intent 객체를 받는다
 int click = intent.getIntExtra("click", 0);
 //즐겨찾기 클릭 횟수가 1일시
 if(click==1){
 mypage_rt01.setVisibility(View.VISIBLE);
 Toast.makeText(MyPage.this, "마이페이지 등록됐습니다.", 
Toast.LENGTH_SHORT).show();
 }
 //즐겨찾기 클릭 횟수가 2일시
 else{
 mypage_rt01.setVisibility(View.GONE);
 Toast.makeText(MyPage.this, "마이페이지 등록이 해제됐습니다.", 
Toast.LENGTH_SHORT).show();
 }
 //클릭시 해당 가게 페이지로 이동
 mypage_rt01.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 Intent intent = new Intent(MyPage.this, Restaurant01.class);
 startActivity(intent);
 }
 });
 }
}