<?php
 //닷홈 아이디, 비밀번호 입력
 $con = mysqli_connect("localhost", "아이디", "비밀번호", "아이디");
 mysqli_query($con,'SET NAMES utf8');
 $userID = $_POST["userID"];
 $userPassword = $_POST["userPassword"];
 
 //'USER' 테이블에서 userID와 userPassword 검색해 가져옴
 $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = ? 
AND userPassword = ?");

//userID, userPassword 둘다 String 형이라 ss
 mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
 mysqli_stmt_execute($statement);
 mysqli_stmt_store_result($statement);
 mysqli_stmt_bind_result($statement, $userID, $userPassword, $userName, 
$userAge);
 $response = array();
 $response["success"] = false;
 while(mysqli_stmt_fetch($statement)) {
 $response["success"] = true;
 $response["userID"] = $userID;
 $response["userPassword"] = $userPassword;
 $response["userName"] = $userName;
 $response["userAge"] = $userAge; 
 }
 
 //response 값을 반환
 echo json_encode($response);
?>