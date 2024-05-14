package com.Y.OnTheGo;
public class ReviewList {
 String name;
 String message;
 public ReviewList(String name, String message) {
 this.name = name;
 this.message = message;
 }
 //파이어베이스DB값을 읽어 올 때 파라미터가 비어있는 생성자가 필요
 public ReviewList() {
 }
 //Getter & Setter
 public String getName() {
 return name;
 }
 
public void setName(String name) {
 this.name = name;
 }
 public String getMessage() {
 return message;
 }
 public void setMessage(String message) {
 this.message = message;
 }
}