package com.Y.OnTheGo;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;
public class RegisterRequest extends StringRequest {
 //서버url설정
 final static private String URL = "http://lockyman.dothome.co.kr/register.php";
 private Map<String, String> map;
 //private Map<String, String>parameters;
 public RegisterRequest(String userID, String userPassword, String userName, int 
userAge, Response.Listener<String> listener) {
 super(Method.POST, URL, listener, null);
 map = new HashMap<>();
 map.put("userID", userID);
 map.put("userPassword", userPassword);
 map.put("userName", userName);
 map.put("userAge", userAge + "");
}
 @Override
 protected Map<String, String>getParams() throws AuthFailureError {
 return map;
 }
}