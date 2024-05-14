package com.Y.OnTheGo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class ReviewAdapter extends BaseAdapter {
 ArrayList<ReviewList> messageItems;
 LayoutInflater layoutInflater;
 public ReviewAdapter(ArrayList<ReviewList> messageItems, LayoutInflater 
layoutInflater) {
 this.messageItems = messageItems;
 this.layoutInflater = layoutInflater;
 }
 @Override
 public int getCount() {
 return messageItems.size();
 }
 @Override
 public Object getItem(int position) {
 return messageItems.get(position);
 }
 @Override
 public long getItemId(int position) {
 return position;

}
 @Override
 public View getView(int position, View view, ViewGroup viewGroup) {
 //현재 보여줄 번째의(position)의 데이터로 뷰를 생성
 ReviewList item = messageItems.get(position);
 //재활용할 뷰는 사용하지 않음
 View itemView = null;
 //listview에 review_listitem으로 화면입히기
 itemView= layoutInflater.inflate(R.layout.review_listitem,viewGroup,false);
 TextView item_view_name= itemView.findViewById(R.id.item_view_name);
 TextView item_view_comment= 
itemView.findViewById(R.id.item_view_comment);
 item_view_name.setText(item.getName());
 item_view_comment.setText(item.getMessage());
 return itemView;
 }
}