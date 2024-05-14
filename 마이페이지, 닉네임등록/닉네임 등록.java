package com.Y.OnTheGo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class Nickname extends AppCompatActivity {
 EditText etName;
 boolean isFirst= true; //앱을 처음 실행한지 확인할 변수
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_nickname);
 etName=findViewById(R.id.et_Nickname);
 //접속한 적이 있었는지 체크
 if(N.nickName!=null) {
 etName.setText(N.nickName);
 isFirst=false;
 }
 }
 @Override
 protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent 
data) {
 super.onActivityResult(requestCode, resultCode, data);
 switch (requestCode) {
 case 10:
 if(resultCode==RESULT_OK) { }
 break;
 }
 }
 public void clickBtn(View view) {
 //처음 접속이 아닐때
 if(!isFirst) {
 //ReviewActivity로 전환
 Intent intent= new Intent(this, ReviewActivity.class);
 startActivity(intent);
 finish();
 }
 else{
 //데이터 저장 함수
 saveData();
 }
 }
//데이터 저장 함수
 void saveData() {
 //EditText의 닉네임가져오기 [전역변수에]
 N.nickName= etName.getText().toString();
 Toast.makeText(Nickname.this, "프로필 저장 완료", 
Toast.LENGTH_SHORT).show();
 //파이어베이스DB에 nickName저장
 //파이어베이스 DB관리자 객체
 FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
 //DB의 profile에 정보 저장, 가져오기
 DatabaseReference profileRef= firebaseDatabase.getReference("profiles");
 profileRef.child(N.nickName).setValue(N.nickName);
 //개인 핸드폰에 nickName을 저장
 SharedPreferences preferences= 
getSharedPreferences("account",MODE_PRIVATE);
 SharedPreferences.Editor editor=preferences.edit();
 editor.putString("nickName", N.nickName);
 editor.commit();
 //저장후 화면 전환
 Intent intent=new Intent(Nickname.this, ReviewActivity.class);
 startActivity(intent);
 finish();
 }
}