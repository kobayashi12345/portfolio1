<%-- リスト10-17の状態 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User,model.Mutter2,java.util.List" %>
<%
// セッションスコープに保存されたユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
// アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter2> mutterList =
(List<Mutter2>) application.getAttribute("mutterList");
// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
p{
font-size:16px;
}
#like_max {
font-size:24px;
color:#FF0000
}
#like_normal {
font-size:24px;
}
#dislike_normal {
font-size:12px;
color:#888888
}
#dislike_max {
font-size:12px;
color:#FFFFFF
}
</style>
<meta charset="UTF-8">
<title>コメンターメイン</title>
</head>
<body>
<h1>Commenter！</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="/Commenter/Logout_2">ログアウト</a>
</p>
<p><a href="/Commenter/Main_2">更新</a></p>
<form action="/Commenter/Main_2" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>
<% int i = 0;
	int hantei;
	for(Mutter2 mutter : mutterList){
	  hantei = mutter.getLike() - mutter.getDislike();
	  if(hantei >= 20){%>
<p id="like_max">
	  <%}else if(hantei >= 10){%>
<p id="like_normal">
	  <%}else if(hantei <= -20){%>
<p id="dislike_max">
	  <%}else if(hantei <= -10){%>
<p id="dislike_normal">
	  <%}else {%>
<p>
	  <%}%>
	  <%=mutter.getUserName()%>：<%=mutter.getText()%></p>
<p><a href="/Commenter/Main_2?like=<%= i %>">Good </a><%= mutter.getLike() %>回　
<a href="/Commenter/Main_2?dislike=<%= i %>">Bad </a><%= mutter.getDislike() %>回</p>
<%  	i++;
	} %>
</body>
</html>