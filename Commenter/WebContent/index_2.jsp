<%-- リスト10-3の状態 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメンターログイン</title>
</head>
<body>
<h1>Commenter へようこそ！！！</h1>
<form action="/Commenter/Login_2" method="post">
ユーザー名：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン"><br>
<br>
※ユーザー名には「小林」、パスワードには「1111」と入力してください。<br>
</form>
</body>
</html>