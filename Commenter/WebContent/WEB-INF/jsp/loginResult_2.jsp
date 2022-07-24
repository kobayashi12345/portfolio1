<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%
// セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメンターログイン結果</title>
</head>
</head>
<body>
<h1>Login</h1>
<% if(loginUser != null) { %>
<p>ログインに成功しました。</p>
<p>ようこそ<%= loginUser.getName() %>さん</p>
<a href="/Commenter/Main_2">Comment 投稿・閲覧へ</a>
<% } else { %>
<p>ログインに失敗しました。</p>
<a href="/Commenter/index_2.jsp">TOPへ</a>
<% } %>
</body>
</html>