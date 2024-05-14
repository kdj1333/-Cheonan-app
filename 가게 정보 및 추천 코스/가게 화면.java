package com.Y.OnTheGo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class Restaurant01 extends AppCompatActivity {
 int click =0;
@Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.restaurant01);
 ImageView Rest01_iv_back = (ImageView) findViewById(R.id.Rest01_iv_back);
 ImageView Rest01_iv_course = (ImageView) 
findViewById(R.id.Rest01_iv_course);
 ImageView Rest01_iv_mypage = (ImageView) 
findViewById(R.id.Rest01_iv_mypage);
 ImageView Rest01_iv_review = (ImageView) 
findViewById(R.id.Rest01_iv_review);
 //버튼 클릭 시
 View.OnClickListener listener = new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 switch (v.getId())
 {
 //뒤로가기 버튼
 case R.id.Rest01_iv_back:
 Intent intent = new Intent(Restaurant01.this, 
MainActivity.class);
 startActivity(intent);
 break;
 //추천코스 버튼
 case R.id.Rest01_iv_course:
 Intent intent2 = new Intent(Restaurant01.this, 
Restaurant01_Course.class);
 startActivity(intent2);
 break;
 //마이페이지 버튼
 case R.id.Rest01_iv_mypage:
 click++;
 Intent intent3 = new Intent(getApplicationContext(), 
MyPage.class);
 //click값 마이페이지로 넘겨줌
 intent3.putExtra("click", click);
 startActivity(intent3);
 //한번 클릭시 이미지 변경
 Rest01_iv_mypage.setImageResource(R.drawable.main2_03_02);
 //click 횟수가 2일시 0으로 변경
 if(click==2) {
 click=0;
//두번 클릭시 원래 이미지로 돌아옴
Rest01_iv_mypage.setImageResource(R.drawable.main2_03);
 }
 break;
 //리뷰페이지 버튼
 case R.id.Rest01_iv_review:
 Intent intent4 = new Intent(Restaurant01.this, 
Nickname.class);
 startActivity(intent4);
 break;
 }
 }
 };
 Rest01_iv_back.setOnClickListener(listener);
 Rest01_iv_course.setOnClickListener(listener);
 Rest01_iv_mypage.setOnClickListener(listener);
 Rest01_iv_review.setOnClickListener(listener);
 }
}