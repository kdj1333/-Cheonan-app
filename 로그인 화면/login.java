package com.Y.OnTheGo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
public class LoginActivity extends AppCompatActivity {
 private EditText et_id, et_pw;
 private ImageView btn_login, btn_register;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_login);
 et_id = (EditText) findViewById(R.id.login_et_id);
 et_pw = (EditText) findViewById(R.id.login_et_pw);
 btn_login = findViewById(R.id.login_btn_login);
 btn_register = findViewById(R.id.login_btn_register);
 btn_register.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
 startActivity(intent);
 }
 });
 btn_login.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 String userID = et_id.getText().toString();
 String userPass = et_pw.getText().toString();
 Response.Listener<String> responseListener = new 
Response.Listener<String>() {
 @Override
 public void onResponse(String response) {
 try {
 //JSONObject를 받아서 boolean으로 계산
JSONObject jsonObject = new JSONObject(response);
 boolean success = jsonObject.getBoolean("success");
//로그인 성공시
if (success) {
 String userID = jsonObject.getString("userID");
String userPass = 
jsonObject.getString("userPassword");
 Toast.makeText(getApplicationContext(), "로그인에 
성공하였습니다", Toast.LENGTH_SHORT).show();
 Intent intent = new Intent(LoginActivity.this, 
MainActivity.class);
 intent.putExtra("userID", userID);
intent.putExtra("userPass", userPass);
startActivity(intent);
 } else {
 Toast.makeText(getApplicationContext(), "비밀번호 
또는 아이디가 맞지않거나, 존재하지않습니다", Toast.LENGTH_SHORT).show();
 return;
 }
 } catch (JSONException e) {
 e.printStackTrace();
 }
 }
 };
 //서버로 Volley를 이용해서 요청
 LoginRequest loginRequest = new LoginRequest(userID, userPass, 
responseListener);
 RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
 queue.add(loginRequest);
 
 }
 });
 }
}