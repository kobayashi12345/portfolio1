package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout_1")
public class Logout_1 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    // セッションスコープを破棄
    HttpSession session = request.getSession();
    session.invalidate();

    // ログアウト画面にフォワード
    RequestDispatcher dispatcher =
        request.getRequestDispatcher("/WEB-INF/jsp/logout_1.jsp");
    dispatcher.forward(request, response);
  }
}