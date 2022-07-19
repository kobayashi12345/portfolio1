package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter2;
import model.PostMutterLogic2;
import model.User;

// つぶやきに日時を追加
@WebServlet("/Main_2")
public class Main_2 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String like = request.getParameter("like");
    String dislike = request.getParameter("dislike");
    // つぶやきリストをアプリケーションスコープから取得
    ServletContext application = this.getServletContext();
    List<Mutter2> mutterList =
        (List<Mutter2>) application.getAttribute("mutterList");
    // 取得できなかった場合は、つぶやきリストを新規作成して
    // アプリケーションスコープに保存
    if (mutterList == null) {
      mutterList = new ArrayList<>();
      application.setAttribute("mutterList", mutterList);
    }
    // 入力値チェック
    PostMutterLogic2 postMutterLogic = new PostMutterLogic2();
    if (like != null ) {
        postMutterLogic.liked(mutterList,Integer.parseInt(like));
        application.setAttribute("mutterList", mutterList);
    }else if(dislike != null) {
        postMutterLogic.disliked(mutterList,Integer.parseInt(dislike));
        application.setAttribute("mutterList", mutterList);
    }
    // ログインしているか確認するため
    // セッションスコープからユーザー情報を取得
    HttpSession session = request.getSession();
    User loginUser = (User) session.getAttribute("loginUser");
    if (loginUser == null) { // ログインしていない場合
      // リダイレクト
      response.sendRedirect("/docoTsubu/");
    } else { // ログイン済みの場合
      // フォワード
      RequestDispatcher dispatcher =
          request.getRequestDispatcher("/WEB-INF/jsp/main_2.jsp");
      dispatcher.forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String text = request.getParameter("text");

    // 入力値チェック
    if (text != null && text.length() != 0) {
    	SimpleDateFormat f = new SimpleDateFormat("（yyyy/MM/dd HH:mm:ss）");
    	Date now = new Date();
    	text += "　";
    	text += f.format(now);

      // アプリケーションスコープに保存されたつぶやきリストを取得
      ServletContext application = this.getServletContext();
      List<Mutter2> mutterList =
          (List<Mutter2>) application.getAttribute("mutterList");

      // セッションスコープに保存されたユーザー情報を取得
      HttpSession session = request.getSession();
      User loginUser = (User) session.getAttribute("loginUser");

      // つぶやきをつぶやきリストに追加
      Mutter2 mutter = new Mutter2(loginUser.getName(), text);
      PostMutterLogic2 postMutterLogic = new PostMutterLogic2();
      postMutterLogic.execute(mutter, mutterList);

      // アプリケーションスコープにつぶやきリストを保存
      application.setAttribute("mutterList", mutterList);
    } else {
      //エラーメッセージをリクエストスコープに保存
      request.setAttribute("errorMsg", "つぶやきが入力されていません");
    }

    // メイン画面にフォワード

    RequestDispatcher dispatcher =
        request.getRequestDispatcher("/WEB-INF/jsp/main_2.jsp");

    dispatcher.forward(request, response);
  }
}