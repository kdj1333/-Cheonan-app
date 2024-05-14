package com.Y.OnTheGo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
public class ReviewActivity extends AppCompatActivity {
 EditText et;
 ListView listView;
 ArrayList<ReviewList> messageItems = new ArrayList<>();
 ReviewAdapter adapter;
 ImageView Rv_iv_back;
//파이어베이스 DB 관리객체참조변수
 FirebaseDatabase firebaseDatabase;
 //챗 노드의참조객체참조변수
 DatabaseReference chatRef;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_review);
 et = findViewById(R.id.et);
 listView = findViewById(R.id.listview);
 adapter = new ReviewAdapter(messageItems, getLayoutInflater());
 listView.setAdapter(adapter);
 //파이어베이스에 데이터베이스관리객체와챗 노드참조객체얻어오기
 firebaseDatabase= FirebaseDatabase.getInstance();
 chatRef= firebaseDatabase.getReference("chat");
 // 파이어베이스DB에서 리뷰메세지 불러오기
 // 'chat'노드에 저장된 데이터들 읽어오기
 // chatRef에 데이터가변경되는것의 리스너 추가
 chatRef.addChildEventListener(new ChildEventListener() {
 
 @Override
 public void onChildAdded(@NonNull DataSnapshot dataSnapshot, 
@Nullable String s) {
 //새로 추가된 데이터(MessageItem객체) 가져오기
 ReviewList messageItem = dataSnapshot.getValue(ReviewList.class);
 //새로운 메세지를 리스트 뷰에 추가하기위해 ArrayList에 추가
 messageItems.add(messageItem);
 //리스트뷰 갱신
 adapter.notifyDataSetChanged();
 //리스트뷰의 마지막 위치로 스크롤 이동
 listView.setSelection(messageItems.size() - 1);
 }
 @Override
 public void onChildChanged(@NonNull DataSnapshot dataSnapshot, 
@Nullable String s) {
 }
 @Override
 public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
 }
 @Override
 public void onChildMoved(@NonNull DataSnapshot dataSnapshot, 
@Nullable String s) {
 }
 @Override
public void onCancelled(@NonNull DatabaseError databaseError) {
 }
 });
 Rv_iv_back = findViewById(R.id.Rv_iv_back);
 Rv_iv_back.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 Intent intent = new Intent(ReviewActivity.this, Restaurant01.class);
 startActivity(intent);
 }
 });
 }
 public void clickSend(View view) {
 //파이어베이스 DB에 저장할 값
 String nickName= N.nickName;
 String message= et.getText().toString();
 //파이어베이스 DB에 저장할 값(MessageItem객체) 설정
 ReviewList messageItem= new ReviewList(nickName,message);
 //'char'노드에 MessageItem객체를 통해
 chatRef.push().setValue(messageItem);
 //EditText에 있는글씨지우기
 et.setText("");
 }
}