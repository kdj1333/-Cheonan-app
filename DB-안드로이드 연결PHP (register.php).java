<?php 
 //닷홈 아이디, 비밀번호 입력
 $con = mysqli_connect("localhost", "아이디", "비밀번호", "아이디");
 mysqli_query($con,'SET NAMES utf8');
 $userID = $_POST["userID"];
 $userPassword = $_POST["userPassword"];
 $userName = $_POST["userName"];
 $userAge = $_POST["userAge"];
 //'USER' 테이블에 변수값을 집어넣음
 $statement = mysqli_prepare($con, "INSERT INTO USER VALUES (?,?,?,?)");
 //해당 변수들은 차례대로 String, String, String, Int형
 mysqli_stmt_bind_param($statement, "sssi", $userID, $userPassword, $userName, $userAge);

 mysqli_stmt_execute($statement);
 $response = array();
 $response["success"] = true;
 //response 값을 반환
 echo json_encode($response);
?>
