package com.Y.OnTheGo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
public class RegisterActivity extends AppCompatActivity {
 private EditText et_id, et_pw, et_name, et_age;
 private ImageView btn_register1, btn_back;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate( savedInstanceState );
 setContentView( R.layout.activity_register );
 //아이디값 찾아주기
 et_id = findViewById( R.id.register_et_id );
 et_pw = findViewById( R.id.register_et_pw );
 et_name = findViewById( R.id.register_et_name );
 et_age = findViewById( R.id.register_et_age );
 //회원가입 버튼 클릭 시 수행
 btn_register1 = findViewById( R.id.register_btn_register );
 btn_register1.setOnClickListener( new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 String userID = et_id.getText().toString();
 String userPass = et_pw.getText().toString();
 String userName = et_name.getText().toString();
 int userAge = Integer.parseInt( et_age.getText().toString() );
 Response.Listener<String> responseListener = new 
Response.Listener<String>() {
 @Override
 public void onResponse(String response) {
 try {
 JSONObject jsonObject = new JSONObject( response );
 boolean success = jsonObject.getBoolean( "success" );
 //회원가입 성공시
if(success) {
 Toast.makeText( getApplicationContext(), "성공", 
Toast.LENGTH_SHORT ).show();
 Intent intent = new Intent( RegisterActivity.this, 
LoginActivity.class );
 startActivity( intent );
//회원가입 실패시
 } else {
 Toast.makeText( getApplicationContext(), "실패", 
Toast.LENGTH_SHORT ).show();
 return;
 }
 } catch (JSONException e) {
 e.printStackTrace();
 }
}
 };
 //서버로 Volley를 이용해서 요청
 RegisterRequest registerRequest = new RegisterRequest( userID, 
userPass, userName, userAge, responseListener);
 RequestQueue queue = Volley.newRequestQueue( RegisterActivity.this 
);
 queue.add( registerRequest );
 }
 });
 //뒤로가기 버튼
 btn_back = findViewById(R.id.register_btn_back);
 btn_back.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
 startActivity(intent);
 }
 });
 }
}